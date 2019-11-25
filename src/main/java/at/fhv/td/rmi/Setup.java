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
    private Setup() {
    }

    public static void setupRmiRegistry(String ipAddress) {
        try {
            System.setProperty("java.rmi.server.hostname", ipAddress);
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

            ClientSessionFactoryImpl clientFactory = new ClientSessionFactoryImpl();

            Naming.rebind("rmi://" + ipAddress + "/clientFactory", clientFactory);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
