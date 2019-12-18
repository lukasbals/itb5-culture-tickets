package at.fhv.td.communication.rmi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Lukas Bals
 */
public class SetupRMI {
    private final static int PORT = 25565;
    private static String IP_ADDRESS;

    private SetupRMI() {
    }

    static {
        try {
            String host = InetAddress.getLocalHost().toString();
            IP_ADDRESS = host.split("/")[1];
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
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
