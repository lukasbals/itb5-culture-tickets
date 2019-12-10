package at.fhv.td.communication.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ILoadClient extends Remote {
    List<IClientDTO> loadClients() throws RemoteException;
}
