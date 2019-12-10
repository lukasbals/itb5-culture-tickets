package at.fhv.td.communication.rmi;

import at.fhv.td.application.UserController;
import at.fhv.td.domain.assembler.TopicAssembler;
import at.fhv.td.communication.rmi.interfaces.IMessageFeed;
import at.fhv.td.communication.rmi.interfaces.ITopicDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lukas Bals
 */
public class MessageFeedImpl extends UnicastRemoteObject implements IMessageFeed {
    private static final long serialVersionUID = -4642934717118697213L;

    public MessageFeedImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ITopicDTO> getTopics(String username) throws RemoteException {
        return UserController.getTopics(username).stream().map(TopicAssembler::toTopicDTO).collect(Collectors.toList());
    }
}
