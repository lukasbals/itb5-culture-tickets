package at.fhv.td.communication.rmi;

import at.fhv.td.application.TopicController;
import at.fhv.td.application.UserController;
import at.fhv.td.communication.dto.TopicDTO;
import at.fhv.td.domain.assembler.TopicAssembler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lukas Bals
 */
public class MessageFeedRMIImpl extends UnicastRemoteObject implements IMessageFeedRMI {
    private static final long serialVersionUID = -4642934717118697213L;

    public MessageFeedRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public List<TopicDTO> getTopics(String username) throws RemoteException {
        return UserController.getTopics(username).stream().map(TopicAssembler::toTopicDTO).collect(Collectors.toList());
    }

    @Override
    public List<TopicDTO> getAllTopics() throws RemoteException {
        return TopicController.getTopics().stream().map(TopicAssembler::toTopicDTO).collect(Collectors.toList());
    }
}
