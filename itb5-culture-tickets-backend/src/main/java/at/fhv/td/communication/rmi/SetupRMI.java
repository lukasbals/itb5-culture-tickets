package at.fhv.td.communication.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Lukas Bals
 */
public class SetupRMI {
        private final static String IP_ADDRESS = "10.0.51.93";
//    private final static String IP_ADDRESS = "localhost";
    private final static int PORT = 25565;

    private SetupRMI() {
    }

    public static void setupRmiRegistry() {
        try {
            System.setProperty("java.rmi.server.hostname", IP_ADDRESS);

            Registry reg = LocateRegistry.createRegistry(PORT);
            ClientSessionFactoryRMIImpl clientFactory = new ClientSessionFactoryRMIImpl();

            reg.rebind("rmi://" + IP_ADDRESS + ":" + PORT + "/clientFactoryRMI", clientFactory);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
