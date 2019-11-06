package at.fhv.td.domain.assembler;

import at.fhv.td.domain.Artist;
import at.fhv.td.domain.Location;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.Tour;
import at.fhv.td.domain.interfaces.IEvent;
import at.fhv.td.dto.EventDetailedViewDTO;
import at.fhv.td.rmi.interfaces.IEventDetailedViewDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class EventDetailAssemblerTest {
    private Set<Artist> _artists;
    private Set<PlaceCategory> _placeCats;
    private String _desc = "MMMMMMonster";
    private String _artist1 = "BakaBoing";
    private String _genre1 = "Klassik";
    private String _address = "blubbweg 3";
    private String _building = "Montforthaus";
    private String _category = "Konzert";
    private LocalDate _date = LocalDate.now();
    private String _cat1 = "Kat 1";

    @Mock
    private IEvent _event;
    @Mock
    private Tour _tour;

    @Before
    public void setup() {
        _artists = new HashSet<Artist>();
        Artist artist1 = new Artist();
        artist1.setArtistName(_artist1);
        artist1.setGenre(_genre1);
        _artists.add(artist1);

        Location location = new Location();
        location.setAddress(_address);
        location.setBuilding(_building);

        _placeCats = new HashSet<PlaceCategory>();
        PlaceCategory placeCat = new PlaceCategory();
        placeCat.setCategoryname(_cat1);
        placeCat.setPrice(20f);
        _placeCats.add(placeCat);

        when(_event.getTour()).thenReturn(_tour);
        when(_event.getTour().getArtists()).thenReturn(_artists);
        when(_event.getTour().getDescription()).thenReturn(_desc);
        when(_event.getLocation()).thenReturn(location);
        when(_event.getTour().getCategory()).thenReturn(_category);
        when(_event.getSeatReservationPossible()).thenReturn(true);
        when(_event.getDate()).thenReturn(_date);
        when(_event.getEventId()).thenReturn(1L);
        when(_event.getPlaceCategories()).thenReturn(_placeCats);
    }

    @Test
    public void toEventDetailedViewDTOTest() throws RemoteException {
        EventDetailedViewDTO expected = new EventDetailedViewDTO();
        expected.setArtists(_artists.stream().map(artist -> artist.getArtistname()).collect(Collectors.joining(", ")));
        expected.setCategory(_category);
        expected.setDate(_date);
        expected.setDescription(_desc);
        expected.setEventId(1L);
        expected.setGenres(new String[]{_genre1});
        expected.setLocation(String.join(", ", _address, _building));
        expected.setPlaceCategories(new String[]{_cat1});
        expected.setPrices(new Float[]{20f});
        expected.setSeatReservationPossible(true);

        IEventDetailedViewDTO dto = EventDetailAssembler.toEventDetailedViewDTO(_event);

        assertEquals(expected.getArtists(), dto.getArtists());
        assertEquals(expected.getCategory(), dto.getCategory());
        assertEquals(expected.getDate(), dto.getDate());
        assertEquals(expected.getDescription(), dto.getDescription());
        assertEquals(expected.getEventId(), dto.getEventId());
        Assert.assertArrayEquals(expected.getGenres(), dto.getGenres());
        assertEquals(expected.getLocation(), dto.getLocation());
        assertEquals(expected.getMinPrice(), dto.getMinPrice());
        Assert.assertArrayEquals(expected.getPlaceCategories(), dto.getPlaceCategories());
        Assert.assertArrayEquals(expected.getPrices(), dto.getPrices());
    }
}
