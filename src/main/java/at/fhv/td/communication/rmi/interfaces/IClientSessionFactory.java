package at.fhv.td.communication.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientSessionFactory extends Remote {
    IClientSession login(String userName, String password, boolean encrypted) throws RemoteException;
}
