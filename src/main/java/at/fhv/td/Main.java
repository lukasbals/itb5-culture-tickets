package at.fhv.td;

import at.fhv.td.domain.Client;
import at.fhv.td.persistence.DBConnection;
import at.fhv.td.persistence.broker.ClientBroker;

/**
 * @author Lukas Bals
 */
public class Main {
    public static void main(String[] args) {
        DBConnection.setupDBConnection();

        // The following code can be removed later
        while (!DBConnection.connected()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
        Client client1 = new Client();
        client1.setFirstname("Elisabeth");
        client1.setLastname("Beer");
        client1.setAddress("Hittisau");
        ClientBroker.getInstance().save(client1);
        System.out.println(ClientBroker.getInstance().getAll());
    }
}
