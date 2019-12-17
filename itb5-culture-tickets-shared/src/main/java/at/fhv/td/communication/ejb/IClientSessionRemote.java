package at.fhv.td.communication.ejb;

import at.fhv.td.communication.IClientSession;

import javax.ejb.Remote;

@Remote
public interface IClientSessionRemote extends IClientSession {
    boolean login(String userName);
}
