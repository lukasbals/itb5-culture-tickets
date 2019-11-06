package at.fhv.td.rmi;

import at.fhv.td.application.TicketController;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.TicketAnswer;
import at.fhv.td.domain.assembler.TicketAnswerAssembler;
import at.fhv.td.domain.assembler.TicketAssembler;
import at.fhv.td.dto.TicketAnswerDTO;
import at.fhv.td.rmi.interfaces.IBuyTicket;
import at.fhv.td.rmi.interfaces.ITicketDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class BuyTicketImpl extends UnicastRemoteObject implements IBuyTicket {

    public BuyTicketImpl() throws RemoteException {
        super();
    }

    @Override
    public TicketAnswerDTO buyTicket(ITicketDTO ticketDto, Map<Integer, Integer[]> seatPlaceReservations) throws RemoteException {
        Ticket basicTicket = TicketAssembler.toTicket(ticketDto);
        TicketAnswer answer = TicketController.buyTicket(basicTicket, seatPlaceReservations);
        return TicketAnswerAssembler.toTicketAnswerDTO(answer);
    }
}
