package at.fhv.td.communication.ejb;

import at.fhv.td.communication.IClientSessionFactory;

import javax.ejb.Remote;

@Remote
public interface IClientSessionFactoryRemote extends IClientSessionFactory {
    IClientSessionRemote login(String userName, String password, boolean encrypted);
}
