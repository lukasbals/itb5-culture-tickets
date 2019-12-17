package at.fhv.td.communication;

import at.fhv.td.communication.dto.ClientDTO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

public interface ILoadClient extends Serializable {
    List<ClientDTO> loadClients() throws RemoteException;
}
