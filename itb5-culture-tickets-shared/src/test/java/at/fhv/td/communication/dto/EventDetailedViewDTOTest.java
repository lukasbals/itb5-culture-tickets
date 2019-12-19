package at.fhv.td.communication.dto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class EventDetailedViewDTOTest {
    private EventDetailedViewDTO _testEventDto;

    @Mock
    private EventDetailedViewDTO _anotherTestEventDto;

    @Before
    public void before() {
        _testEventDto = new EventDetailedViewDTO();
    }

    @Test
    public void getEventNameTest() {
        String eventName = "MMMMMonsert";
        _testEventDto.setEventName(eventName);
        assertEquals(eventName, _testEventDto.getEventName());
    }

    @Test
    public void getAndSetArtists() {
        String artists = "BakaBoing, Vani";
        _testEventDto.setArtists(artists);
        assertEquals(artists, _testEventDto.getArtists());
    }

    @Test
    public void getAndSetDescription() {
        String description = "BOINBOINB";
        _testEventDto.setDescription(description);
        assertEquals(description, _testEventDto.getDescription());
    }

    @Test
    public void getAndSetGenres() {
        String[] genres = new String[]{"Rock", "Classic"};
        _testEventDto.setGenres(genres);
        Assert.assertArrayEquals(genres, _testEventDto.getGenres());
    }

    @Test
    public void getAndSetLocation() {
        String location = "Sprengelweg 5, 6700, A";
        _testEventDto.setLocation(location);
        assertEquals(location, _testEventDto.getLocation());
    }

    @Test
    public void getAndSetPrices() {
        Float minPrice = 3f;
        Float[] prices = new Float[]{minPrice, 12f, 5f};
        _testEventDto.setPrices(prices);
        Assert.assertArrayEquals(prices, _testEventDto.getPrices());
        assertEquals(minPrice, _testEventDto.getMinPrice());
    }

    @Test
    public void getAndSetPossibleSeatReservation() {
        boolean reservationPossible = true;
        _testEventDto.setSeatReservationPossible(reservationPossible);
        assertEquals(reservationPossible, _testEventDto.isSeatReservationPossible());
    }

    @Test
    public void getAndSetPlaceCategories() {
        String[] categories = new String[]{"Kat 1", "Kat 2"};
        _testEventDto.setPlaceCategories(categories);
        Assert.assertArrayEquals(categories, _testEventDto.getPlaceCategories());
    }

    @Test
    public void getAndSetPlaceCategoriesId() {
        Long[] categoriesId = new Long[]{1L, 2L, 3L};
        _testEventDto.setPlaceCategoriesId(categoriesId);
        Assert.assertArrayEquals(categoriesId, _testEventDto.getPlaceCategoriesId());
    }

    @Test
    public void getAndSetCategory() {
        String category = "Konzert";
        _testEventDto.setCategory(category);
        assertEquals(category, _testEventDto.getCategory());
    }

    @Test
    public void getAndSetCategoryAmount() {
        Integer[] amounts = new Integer[]{1, 10, 8};
        _testEventDto.setPlaceCategoriesAmount(amounts);
        Assert.assertArrayEquals(amounts, _testEventDto.getPlaceCategoriesAmount());
    }

    @Test
    public void getAndSetDate() {
        LocalDate date = LocalDate.now();
        _testEventDto.setDate(date);
        assertEquals(date, _testEventDto.getDate());
    }

    @Test
    public void getAndSetEventId() {
        Long id = 1L;
        _testEventDto.setEventId(id);
        assertEquals(id, _testEventDto.getEventId());
    }

    @Test
    public void hashCodeAndEqualsTest() {
        _testEventDto.setEventId(3L);
        EventDetailedViewDTO compareDto = new EventDetailedViewDTO();
        compareDto.setEventId(3L);

        assertTrue(_testEventDto.equals(compareDto));
        assertEquals(compareDto.hashCode(), _testEventDto.hashCode());
    }

    @Test
    public void equalsFailTest() {
        _testEventDto.setEventId(3L);

        assertFalse(_testEventDto.equals(new String("")));
        assertFalse(_testEventDto.equals(_anotherTestEventDto));
    }
}
