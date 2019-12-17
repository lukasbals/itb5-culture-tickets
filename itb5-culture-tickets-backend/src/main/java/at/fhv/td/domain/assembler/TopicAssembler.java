package at.fhv.td.domain.assembler;

import at.fhv.td.communication.dto.TopicDTO;
import at.fhv.td.domain.interfaces.ITopic;

/**
 * @author Lukas Bals
 */
public class TopicAssembler {
    private TopicAssembler() {
    }

    public static TopicDTO toTopicDTO(ITopic topic) {
        TopicDTO topicDTO = null;
        topicDTO = new TopicDTO();
        topicDTO.setName(topic.getName());
        return topicDTO;
    }
}
