package at.fhv.td.application;

import at.fhv.td.domain.Client;
import at.fhv.td.persistence.broker.ClientBroker;

import java.util.List;

/**
 * @author Lukas Bals
 */
public class ClientController {
    private ClientController() {
    }

    public static List<Client> getClients() {
        return ClientBroker.getInstance().getAll();
    }
}
