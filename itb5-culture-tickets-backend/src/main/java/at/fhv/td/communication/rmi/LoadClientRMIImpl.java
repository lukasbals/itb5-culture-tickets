package at.fhv.td.communication.rmi;

import at.fhv.td.application.ClientController;
import at.fhv.td.communication.dto.ClientDTO;
import at.fhv.td.domain.assembler.ClientAssembler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

public class LoadClientRMIImpl extends UnicastRemoteObject implements ILoadClientRMI {

    private static final long serialVersionUID = 2682330981477041481L;

    public LoadClientRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ClientDTO> loadClients() throws RemoteException {
        return ClientController.getClients().stream().map(ClientAssembler::toClientDTO).collect(Collectors.toList());
    }
}
