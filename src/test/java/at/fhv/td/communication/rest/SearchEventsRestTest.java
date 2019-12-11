package at.fhv.td.communication.rest;

import at.fhv.td.application.EventController;
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

import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({EventBroker.class, EventController.class})
public class SearchEventsRestTest {
    private Set<Artist> _artists = new HashSet<>();
    private List<Event> _events = new LinkedList<>();

    @Mock
    private Event _event1;
    @Mock
    private Artist _artist1;
    @Mock
    private Tour _tour1;
    @Mock
    private Location _location;
    @Mock
    private EventBroker _eventBroker;

    @Before
    public void before() {
        _artists.add(_artist1);
        _events.add(_event1);

        mockStatic(EventBroker.class);
        when(EventBroker.getInstance()).thenReturn(_eventBroker);
        when(_eventBroker.getAll()).thenReturn(_events);

        when(_artist1.getArtistname()).thenReturn("Sondaschule");

        when(_event1.getDate()).thenReturn(LocalDate.of(2020, 11, 14));
        when(_event1.getEventName()).thenReturn("PPPPPPPoetry");
        when(_event1.getLocation()).thenReturn(_location);
        when(_event1.getLocation().toString()).thenReturn("Spielboden");
        when(_event1.getTour()).thenReturn(_tour1);
        when(_event1.getTour().getArtists()).thenReturn(_artists);

        _events.add(_event1);

        mockStatic(EventController.class);
    }

    @Test
    public void searchForEvents() {
        when(EventController.searchForEvents(any(String.class), any(String.class), any(String.class), any(LocalDate.class))).thenReturn(_events);

        SearchEventsRest rest = new SearchEventsRest();

        Response resp = rest.searchForEvents(2020,11,14,"","","");
        assertTrue(resp.hasEntity() && resp.getStatus() == 200);
    }

    @Test
    public void searchForEventsFail() {
        when(EventController.searchForEvents(any(String.class), any(String.class), any(String.class), any(LocalDate.class))).thenReturn(null);

        SearchEventsRest rest = new SearchEventsRest();

        Response resp = rest.searchForEvents(0,0,0,"","","");
        assertFalse(resp.hasEntity() && resp.getStatus() == 200);
    }
}