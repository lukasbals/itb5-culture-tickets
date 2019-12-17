package at.fhv.td.communication;

import at.fhv.td.communication.dto.TopicDTO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

public interface IMessageFeed extends Serializable {
    List<TopicDTO> getTopics(String username) throws RemoteException;

    List<TopicDTO> getAllTopics() throws RemoteException;
}
