package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TopicTest {
    private Topic _testTopic;

    @Mock
    private User _user;

    @Before
    public void before() {
        _testTopic = new Topic();
    }

    @Test
    public void getAndSetId() {
        Long id = 10L;
        _testTopic.setId(id);
        assertEquals(id, _testTopic.getId());
    }

    @Test
    public void getAndSetName() {
        String name = "festivals";
        _testTopic.setName(name);
        assertEquals(name, _testTopic.getName());
    }

    @Test
    public void getAndSetUsers() {
        Set<User> users = new HashSet<>();
        users.add(_user);
        _testTopic.setUsers(users);
        assertEquals(1, _testTopic.getUsers().size());
    }
}