package at.fhv.td.dto;

import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;

public class TopicDTOTest {

    @Test
    public void getAndSetName() throws RemoteException {
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setName("name");
        assertEquals("name", topicDTO.getName());
    }
}