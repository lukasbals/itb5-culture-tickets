package at.fhv.td.communication.ejb;

import at.fhv.td.ldap.LDAP;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ClientSessionFactoryRemoteImpl implements IClientSessionFactoryRemote {

    @EJB
    IClientSessionRemote _session;

    @Override
    public IClientSessionRemote login(String userName, String password, boolean encrypted) {
        if (LDAP.callLDAP(userName, password)) {
            if (_session.login(userName)) {
                return _session;
            }
        }
        return null;
    }
}
