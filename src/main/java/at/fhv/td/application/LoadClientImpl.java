package at.fhv.td.application;

import at.fhv.td.domain.ClientAssembler;
import at.fhv.td.domain.EventDetailAssembler;
import at.fhv.td.persistence.broker.ClientBroker;
import at.fhv.td.rmi.interfaces.IClientDTO;
import at.fhv.td.rmi.interfaces.ILoadClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

public class LoadClientImpl extends UnicastRemoteObject implements ILoadClient {

    private static final long serialVersionUID = 2682330981477041481L;

    public LoadClientImpl() throws RemoteException {
        super();
    }
    @Override
    public List<IClientDTO> loadClients() throws RemoteException {
        return ClientBroker.getInstance().getAll().stream()
                .map(e -> new ClientAssembler().toClientDTO(e))
                .collect(Collectors.toList());
    }
}
