package at.fhv.td.application;

import at.fhv.td.domain.Artist;
import at.fhv.td.domain.Event;
import at.fhv.td.domain.Location;
import at.fhv.td.domain.Tour;
import at.fhv.td.persistence.broker.EventBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventBroker.class)
public class EventControllerTest {
    private Set<Artist> _artists = new HashSet<>();
    private Set<Artist> _artists2 = new HashSet<>();
    private List<Event> _events = new LinkedList<>();

    @Mock
    private Event _event1;
    @Mock
    private Event _event2;
    @Mock
    private Artist _artist1;
    @Mock
    private Artist _artist2;
    @Mock
    private Tour _tour1;
    @Mock
    private Tour _tour2;
    @Mock
    private Location _location;
    @Mock
    private EventBroker _eventBroker;

    @Before
    public void before() {
        _artists.add(_artist1);
        _artists.add(_artist2);
        _artists2.add(_artist2);
        _events.add(_event1);
        _events.add(_event2);

        mockStatic(EventBroker.class);
        when(EventBroker.getInstance()).thenReturn(_eventBroker);
        when(_eventBroker.getAll()).thenReturn(_events);

        when(_artist1.getArtistname()).thenReturn("Sondaschule");
        when(_artist2.getArtistname()).thenReturn("WhiteStripes");

        when(_event1.getDate()).thenReturn(LocalDate.of(2020, 11, 14));
        when(_event1.getEventname()).thenReturn("PPPPPPPoetry");
        when(_event1.getLocation()).thenReturn(_location);
        when(_event1.getLocation().toString()).thenReturn("Spielboden");
        when(_event1.getTour()).thenReturn(_tour1);
        when(_event1.getTour().getArtists()).thenReturn(_artists);

        when(_event2.getDate()).thenReturn(LocalDate.of(2020, 11, 14));
        when(_event2.getEventname()).thenReturn("Masters of Disaster on Tour");
        when(_event2.getLocation()).thenReturn(_location);
        when(_event2.getLocation().getLocationString()).thenReturn("Montforthaus");
        when(_event2.getTour()).thenReturn(_tour2);
        when(_event2.getTour().getArtists()).thenReturn(_artists2);
    }

    @Test
    public void checkEventTest() {
        assertTrue(EventController.checkEvent(_event1, null, "stripes", null, null));
        assertTrue(EventController.checkEvent(_event2, "", "", "haus", null));
        assertTrue(EventController.checkEvent(_event2, "disaster", "", "", null));
        assertTrue(EventController.checkEvent(_event2, "disaster", "", "", LocalDate.of(2020, 11, 14)));
        assertTrue(EventController.checkEvent(_event2, "disaster", "", "", LocalDate.MIN));
        assertTrue(EventController.checkEvent(_event1, null, "", "", LocalDate.now()));
        assertFalse(EventController.checkEvent(_event1, null, "boing", null, null));
    }

    @Test
    public void searchForEvents() {
        assertEquals(_events, EventController.searchForEvents(null, "white", "", null));
        assertEquals(1, EventController.searchForEvents(null, "schule", "", null).size());
    }
}