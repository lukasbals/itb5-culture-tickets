package at.fhv.td.communication.rmi;

import at.fhv.td.ldap.LDAP;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientSessionFactoryRMIImpl extends UnicastRemoteObject implements IClientSessionFactoryRMI {

    private static final long serialVersionUID = -9132753231693520420L;

    public ClientSessionFactoryRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public IClientSessionRMI login(String userName, String password, boolean encrypted) throws RemoteException {
        ClientSessionRMIImpl session = null;

        if (LDAP.callLDAP(userName, password)) {
            try {
                session = new ClientSessionRMIImpl(userName);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        return session;
    }
}
