package at.fhv.td.communication.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITopicDTO extends Remote {
    String getName() throws RemoteException;

    void setName(String name) throws RemoteException;
}
