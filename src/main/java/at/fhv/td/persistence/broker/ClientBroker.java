package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Client;

/**
 * @author Lukas Bals
 */
public class ClientBroker extends Broker<Client> {
    private static ClientBroker _clientBroker = null;

    private ClientBroker() {
    }

    @Override
    protected Class<Client> getModelClass() {
        return Client.class;
    }

    public static ClientBroker getInstance() {
        if (_clientBroker == null) {
            _clientBroker = new ClientBroker();
        }
        return _clientBroker;
    }
}
