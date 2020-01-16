package at.fhv.td.communication.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Lukas Bals
 */
public class SetupRMI {
    private static final int PORT = 25565;
    private static String IP_ADDRESS = "10.0.51.93";

    static {
        String ipAddress = System.getenv("CultureTicketsRmiIP");

        if(ipAddress != null && !ipAddress.equals("")){
            IP_ADDRESS = ipAddress;
        }
    }

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
