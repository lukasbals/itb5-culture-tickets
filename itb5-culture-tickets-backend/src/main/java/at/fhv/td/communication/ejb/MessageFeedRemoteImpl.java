package at.fhv.td.communication.ejb;

import at.fhv.td.application.TopicController;
import at.fhv.td.application.UserController;
import at.fhv.td.communication.dto.TopicDTO;
import at.fhv.td.domain.assembler.TopicAssembler;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class MessageFeedRemoteImpl implements IMessageFeedRemote {
    @Override
    public List<TopicDTO> getTopics(String username) {
        return UserController.getTopics(username).stream().map(TopicAssembler::toTopicDTO).collect(Collectors.toList());
    }

    @Override
    public List<TopicDTO> getAllTopics() {
        return TopicController.getTopics().stream().map(TopicAssembler::toTopicDTO).collect(Collectors.toList());
    }
}
