package at.fhv.td.rmi;

import at.fhv.td.ldap.LDAP;
import at.fhv.td.rmi.interfaces.IClientSession;
import at.fhv.td.rmi.interfaces.IClientSessionFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientSessionFactoryImpl extends UnicastRemoteObject implements IClientSessionFactory {

    private static final long serialVersionUID = -9132753231693520420L;

    public ClientSessionFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public IClientSession login(String userName, String password, boolean encrypted) throws RemoteException {
        ClientSessionImpl session = null;

        if(LDAP.callLDAP(userName, password)) {
            session = new ClientSessionImpl(userName);
        }

        return session;
    }
}
