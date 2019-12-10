package at.fhv.td.communication.dto;

import at.fhv.td.communication.rmi.interfaces.ITicketDTO;

import java.io.Serializable;
import java.util.Map;

public class TicketRequestDTO implements Serializable {
    private ITicketDTO _ticketDto;
    private Map<Long, Integer[]> _seatPlaceReservations;

    public ITicketDTO getTicketDto() {
        return _ticketDto;
    }

    public void setTicketDto(ITicketDTO ticketDto) {
        _ticketDto = ticketDto;
    }

    public Map<Long, Integer[]> getSeatPlaceReservations() {
        return _seatPlaceReservations;
    }

    public void setSeatPlaceReservations(Map<Long, Integer[]> seatPlaceReservations) {
        _seatPlaceReservations = seatPlaceReservations;
    }
}
