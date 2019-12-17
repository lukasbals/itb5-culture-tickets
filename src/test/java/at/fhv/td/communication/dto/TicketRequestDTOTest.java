package at.fhv.td.communication.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class TicketRequestDTOTest {
    private TicketRequestDTO _testTicketRequestDTO;
    private Map<String, Integer[]> _seatPlaceReservations;

    @Mock
    private TicketDTO _testTicketDTO;

    @Before
    public void before() {
        _seatPlaceReservations = new HashMap<>();
        _seatPlaceReservations.put("1", new Integer[]{1, 2});
        _testTicketRequestDTO = new TicketRequestDTO();
    }

    @Test
    public void getAndSetSeatPlaceReservations() {
        _testTicketRequestDTO.setSeatPlaceReservations(_seatPlaceReservations);
        assertEquals(_seatPlaceReservations, _testTicketRequestDTO.getSeatPlaceReservations());
    }

    @Test
    public void getAndSetTicketDTO() {
        _testTicketRequestDTO.setTicketDto(_testTicketDTO);
        assertEquals(_testTicketDTO, _testTicketRequestDTO.getTicketDto());
    }
}
