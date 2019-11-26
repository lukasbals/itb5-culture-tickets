package at.fhv.td.jms;

import at.fhv.td.rss.FeedMessage;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.*;

/**
 * @author Lukas Bals
 */
@Singleton
public class Publisher {
    @Resource(lookup = "jms/connectionFactory")
    private ConnectionFactory _factory;
    @Resource(lookup = "jms/festivals")
    private Topic _topic;

    public void publishMessage(FeedMessage feedMessage) {
        ObjectMessage message;
        try (
                Connection connection = _factory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer producer = session.createProducer(_topic)
        ) {
            message = session.createObjectMessage(feedMessage);
            producer.send(message);
        } catch (JMSException e) {
            System.err.println("Error while publishing message.");
        }
    }

    void setFactory(ConnectionFactory factory) {
        _factory = factory;
    }

    void setTopic(Topic topic) {
        _topic = topic;
    }
}
