package at.fhv.td.jms;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.jms.*;
import javax.json.Json;
import javax.json.JsonObject;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Lukas Bals
 */
@Singleton
public class Publisher {

    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory jmsFactory;

    @Resource(lookup = "jms/stocks")
    private Topic jmsTopic;

    private String[] stockCodes = {"MSFT", "GOOGL", "AAPL", "AMZN"};

    @Schedule(second = "*/2", minute = "*", hour = "*", persistent = false)
    public void sendStockInformation() {

        TextMessage message;

        try (Connection connection = jmsFactory.createConnection();
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
             MessageProducer producer = session.createProducer(jmsTopic)) {

            JsonObject stockInformation = Json.createObjectBuilder()
                    .add("stockCode", stockCodes[ThreadLocalRandom.current().nextInt(stockCodes.length)])
                    .add("price", ThreadLocalRandom.current().nextDouble(1.0, 150.0))
                    .add("timestamp", Instant.now().toEpochMilli()).build();

            message = session.createTextMessage();
            message.setText(stockInformation.toString());

            producer.send(message);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
