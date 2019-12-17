package at.fhv.td.communication;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface IClientSessionFactory extends Serializable {
    IClientSession login(String userName, String password, boolean encrypted) throws RemoteException;
}
