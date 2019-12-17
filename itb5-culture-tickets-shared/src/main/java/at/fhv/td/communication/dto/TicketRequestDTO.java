package at.fhv.td.communication.dto;

import java.io.Serializable;
import java.util.Map;

public class TicketRequestDTO implements Serializable {
    private TicketDTO _ticketDto;
    private Map<String, Integer[]> _seatPlaceReservations;

    public TicketDTO getTicketDto() {
        return _ticketDto;
    }

    public void setTicketDto(TicketDTO ticketDto) {
        _ticketDto = ticketDto;
    }

    public Map<String, Integer[]> getSeatPlaceReservations() {
        return _seatPlaceReservations;
    }

    public void setSeatPlaceReservations(Map<String, Integer[]> seatPlaceReservations) {
        _seatPlaceReservations = seatPlaceReservations;
    }
}
