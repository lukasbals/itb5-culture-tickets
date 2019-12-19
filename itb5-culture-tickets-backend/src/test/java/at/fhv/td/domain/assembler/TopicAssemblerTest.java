package at.fhv.td.domain.assembler;

import at.fhv.td.domain.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class TopicAssemblerTest {
    @Mock
    Topic _topic;

    @Test
    public void toTopicDTO() {
        String topicName = "name";
        when(_topic.getName()).thenReturn(topicName);
        assertEquals(topicName, TopicAssembler.toTopicDTO(_topic).getName());
    }
}