package at.fhv.td.communication.ejb;

import at.fhv.td.application.UserController;
import at.fhv.td.communication.dto.TopicDTO;
import at.fhv.td.domain.Topic;
import at.fhv.td.persistence.broker.UserBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserController.class)
public class MessageFeedRemoteImplTest {
    private String _name = "festivals";

    private List<Topic> _topics = new LinkedList<>();
    @Mock
    private Topic _topic;
    @Mock
    private UserBroker _userBroker;

    @Before
    public void before() {
        mockStatic(UserController.class);

        _topics.add(_topic);

        when(_topic.getName()).thenReturn(_name);
        when(UserController.getTopics("lba4683")).thenReturn(_topics);
    }

    @Test
    public void getTopics() {
        MessageFeedRemoteImpl messageFeed = new MessageFeedRemoteImpl();
        List<TopicDTO> topics = messageFeed.getTopics("lba4683");
        assertEquals(_name, topics.get(0).getName());
    }
}