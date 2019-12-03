package at.fhv.td.application;

import at.fhv.td.domain.Topic;
import at.fhv.td.persistence.broker.TopicBroker;
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
@PrepareForTest(TopicBroker.class)
public class TopicControllerTest {
    private List<Topic> _topics = new LinkedList<>();

    @Mock
    private Topic _topic;
    @Mock
    private TopicBroker _topicBroker;

    @Before
    public void before() {
        _topics.add(_topic);

        mockStatic(TopicBroker.class);
        when(TopicBroker.getInstance()).thenReturn(_topicBroker);
        when(_topicBroker.getAll()).thenReturn(_topics);
    }

    @Test
    public void getTopics() {
        assertEquals(_topics, TopicController.getTopics());
    }
}
