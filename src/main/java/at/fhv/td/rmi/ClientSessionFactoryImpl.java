package at.fhv.td.rmi;

import at.fhv.td.application.LoadClientImpl;
import at.fhv.td.application.SearchEventImpl;
import at.fhv.td.rmi.interfaces.IClientSessionFactory;
import at.fhv.td.rmi.interfaces.ILoadClient;
import at.fhv.td.rmi.interfaces.ISearchEvent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientSessionFactoryImpl extends UnicastRemoteObject implements IClientSessionFactory {

    private static final long serialVersionUID = -9132753231693520420L;

    public ClientSessionFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public ISearchEvent createConnection() throws RemoteException {
        return new SearchEventImpl();
    }

    @Override
    public ILoadClient createClient() throws RemoteException {
        return new LoadClientImpl();
    }
}
