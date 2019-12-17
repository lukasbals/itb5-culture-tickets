package at.fhv.td.communication.rmi;

import at.fhv.td.application.EventController;
import at.fhv.td.communication.dto.EventDetailedViewDTO;
import at.fhv.td.domain.Artist;
import at.fhv.td.domain.Event;
import at.fhv.td.domain.Location;
import at.fhv.td.domain.Tour;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EventController.class)
public class SearchEventImplTest {
    private SearchEventRMIImpl _search;
    private Set<Artist> _artists = new HashSet<>();
    private Set<Artist> _artists2 = new HashSet<>();
    private List<Event> _events = new LinkedList<>();
    private String _eventname1 = "PPPPPPPoetry";
    private String _eventname2 = "Masters of Disaster on Tour";

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

    @Before
    public void before() throws RemoteException {
        _search = new SearchEventRMIImpl();
        _artists.add(_artist1);
        _artists.add(_artist2);
        _artists2.add(_artist2);
        _events.add(_event1);
        _events.add(_event2);

        mockStatic(EventController.class);
        when(EventController.searchForEvents("", "", "", null)).thenReturn(_events);

        when(_artist1.getArtistname()).thenReturn("Sondaschule");
        when(_artist2.getArtistname()).thenReturn("WhiteStripes");

        when(_event1.getDate()).thenReturn(LocalDate.of(2020, 11, 14));
        when(_event1.getEventName()).thenReturn(_eventname1);
        when(_event1.getLocation()).thenReturn(_location);
        when(_event1.getLocation().toString()).thenReturn("Spielboden");
        when(_event1.getTour()).thenReturn(_tour1);
        when(_event1.getTour().getArtists()).thenReturn(_artists);

        when(_event2.getDate()).thenReturn(LocalDate.of(2020, 11, 14));
        when(_event2.getEventName()).thenReturn(_eventname2);
        when(_event2.getLocation()).thenReturn(_location);
        when(_event2.getLocation().getLocationString()).thenReturn("Montforthaus");
        when(_event2.getTour()).thenReturn(_tour2);
        when(_event2.getTour().getArtists()).thenReturn(_artists2);
    }

    @Test
    public void searchForEventsTest() throws RemoteException {
        List<EventDetailedViewDTO> events = _search.searchForEvents("", "", "", null);
        assertEquals(2, events.size());
        assertEquals(_eventname1, events.get(0).getEventName());
        assertEquals(_eventname2, events.get(1).getEventName());
    }
}
