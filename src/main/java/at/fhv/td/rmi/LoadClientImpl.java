package at.fhv.td.rmi;

import at.fhv.td.application.ClientController;
import at.fhv.td.domain.assembler.ClientAssembler;
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
    public List<IClientDTO> loadClients() {
        return ClientController.getClients().stream().map(ClientAssembler::toClientDTO).collect(Collectors.toList());
    }
}
