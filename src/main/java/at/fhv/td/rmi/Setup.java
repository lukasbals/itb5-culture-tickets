package at.fhv.td.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Lukas Bals
 */
public class Setup {
    private final static String IP_ADDRESS = "10.0.51.93";

    private Setup() {
    }

    public static void setupRmiRegistry() {
        try {
            System.setProperty("java.rmi.server.hostname", IP_ADDRESS);
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            ClientSessionFactoryImpl clientFactory = new ClientSessionFactoryImpl();

            Naming.rebind("rmi://" + IP_ADDRESS + "/clientFactory", clientFactory);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
