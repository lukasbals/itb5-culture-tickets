package at.fhv.td;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Lukas Bals
 */
public class Main {
    private static String IP_ADDRESS = "10.0.51.93";

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", IP_ADDRESS);
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            CalculatorServant calculator = new CalculatorServant();

            Naming.rebind("rmi://" + IP_ADDRESS + "/calculator", calculator);
            System.out.println("Calculator bound in registry");
        } catch (Exception e) {
            System.out.println("Calculator err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
