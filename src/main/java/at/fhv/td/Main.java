package at.fhv.td;

import at.fhv.td.persistence.DBConnection;
import at.fhv.td.rmi.ClientSessionFactoryImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Lukas Bals
 */
public class Main {
    private static String IP_ADDRESS = "10.0.51.93";

    static {
        if (System.getenv("HOST") != null) {
            IP_ADDRESS = System.getenv("HOST");
        }
    }

    public static void main(String[] args) {
        DBConnection.setupDBConnection();
        setupRmiRegistry();
    }

    private static void setupRmiRegistry() {
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
