package at.fhv.td.communication.dto;

import at.fhv.td.communication.rmi.interfaces.ITopicDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Lukas Bals
 */
public class TopicDTO extends UnicastRemoteObject implements ITopicDTO {
    private static final long serialVersionUID = -6164552315140414172L;
    private String _name;

    public TopicDTO() throws RemoteException {
        super();
    }

    @Override
    public String getName() throws RemoteException {
        return _name;
    }

    @Override
    public void setName(String name) throws RemoteException {
        _name = name;
    }
}
