package at.fhv.td.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author Lukas Bals
 */

@MessageDriven(name = "stockmdb", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/stocks"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")})
public class Listener implements MessageListener {

    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;

        try {
            System.out.println("A new stock information arrived: " + textMessage.getText());

//                JsonReader jsonReader = Json.createReader(new StringReader(textMessage.getText()));
//                JsonObject stockInformation = jsonReader.readObject();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
