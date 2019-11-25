package at.fhv.td;

import at.fhv.td.jms.JMSBroker;
import at.fhv.td.persistence.DBConnection;
import at.fhv.td.rmi.Setup;

/**
 * @author Lukas Bals
 */
public class Main {
    private static String IP_ADDRESS = "10.0.51.93";

    public static void main(String[] args) {
        if (args.length == 1) {
            IP_ADDRESS = args[0];
        }
        DBConnection.setupDBConnection();
        Setup.setupRmiRegistry(IP_ADDRESS);
        JMSBroker.startBrokerService(IP_ADDRESS);
    }
}
