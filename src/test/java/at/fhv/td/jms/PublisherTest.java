package at.fhv.td.jms;

import at.fhv.td.rss.FeedMessage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.jms.*;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class PublisherTest {
    private Publisher _publisher;
    private FeedMessage _feedMessage;

    @Mock
    private ConnectionFactory _factory;
    @Mock
    private Topic _topic;
    @Mock
    private Session _session;
    @Mock
    private MessageProducer _messageProducer;
    @Mock
    private Connection _connection;
    @Mock
    private ObjectMessage _objectMessage;

    @Before
    public void before() throws JMSException {
        _feedMessage = new FeedMessage();
        _feedMessage.setTitle("Title");
        _publisher = new Publisher();
        _publisher.setFactory(_factory);
        _publisher.setTopic(_topic);

        when(_factory.createConnection()).thenReturn(_connection);
        when(_connection.createSession(false, Session.AUTO_ACKNOWLEDGE)).thenReturn(_session);
        when(_session.createProducer(_topic)).thenReturn(_messageProducer);
        when(_session.createObjectMessage(any(FeedMessage.class))).thenReturn(_objectMessage);
    }

    @Test
    public void publishMessage() throws JMSException {
        _publisher.publishMessage(_feedMessage);
        verify(_session, times(1)).createObjectMessage(_feedMessage);
        verify(_messageProducer, times(1)).send(_objectMessage);
    }

    @Test
    public void publishMessageException() throws JMSException {
        when(_factory.createConnection()).thenThrow(JMSException.class);
        _publisher.publishMessage(_feedMessage);
        verify(_session, times(0)).createObjectMessage(_feedMessage);
        verify(_messageProducer, times(0)).send(_objectMessage);
    }
}