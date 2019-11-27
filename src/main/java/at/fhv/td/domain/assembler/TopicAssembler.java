package at.fhv.td.domain.assembler;

import at.fhv.td.domain.interfaces.ITopic;
import at.fhv.td.dto.TopicDTO;

import java.rmi.RemoteException;

/**
 * @author Lukas Bals
 */
public class TopicAssembler {
    private TopicAssembler() {
    }

    public static TopicDTO toTopicDTO(ITopic topic) {
        TopicDTO topicDTO = null;
        try {
            topicDTO = new TopicDTO();
            topicDTO.setName(topic.getName());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return topicDTO;
    }
}
