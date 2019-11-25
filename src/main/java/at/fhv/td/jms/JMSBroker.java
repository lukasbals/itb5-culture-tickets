package at.fhv.td.jms;

import org.apache.activemq.broker.BrokerService;

public class JMSBroker {
    private static BrokerService _broker;

    private JMSBroker() {
    }

    public static void startBrokerService(String ipAddress) {
        try {
            _broker = new BrokerService();
            _broker.addConnector("tcp://" + ipAddress + ":61616");
            _broker.setUseJmx(true);
            _broker.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
