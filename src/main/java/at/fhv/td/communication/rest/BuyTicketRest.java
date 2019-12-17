package at.fhv.td.communication.rest;

import at.fhv.td.application.TicketController;
import at.fhv.td.communication.dto.TicketRequestDTO;
import at.fhv.td.communication.rmi.interfaces.ITicketDTO;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.TicketAnswer;
import at.fhv.td.domain.assembler.TicketAssembler;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/buyTicket")
public class BuyTicketRest {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response buyTicket(TicketRequestDTO ticketRequest) {
        if (ticketRequest != null) {
            try {
                System.out.println(ticketRequest.getTicketDto().getCategoryName());
                System.out.println(ticketRequest.getSeatPlaceReservations().get("1").length);
                System.out.println(ticketRequest.getSeatPlaceReservations().get("1")[0]);

                Ticket basicTicket = TicketAssembler.toTicket(ticketRequest.getTicketDto());
                Map<Long, Integer[]> ticketsToBuy = new HashMap<>();
                for (Map.Entry<String, Integer[]> entry : ticketRequest.getSeatPlaceReservations().entrySet()) {
                    ticketsToBuy.put(new Long(entry.getKey()), entry.getValue());
                }
                TicketAnswer answer = (TicketController.buyTicket(basicTicket, ticketsToBuy));
                AtomicInteger ticketAmount = new AtomicInteger();
                ticketRequest.getSeatPlaceReservations().forEach((cat, seats) -> ticketAmount.addAndGet(seats.length));

                System.out.println(answer.getTickets().size() + " - " + ticketAmount.get());
                if (answer.getTickets().size() == ticketAmount.get()) {
                    ITicketDTO[] tickets = answer.getTickets().stream().map(TicketAssembler::toTicketDTO).toArray(ITicketDTO[]::new);
                    return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(tickets).build();
                }

                // TODO test this!
                return Response.status(409).entity(answer.getMessage()).build();
            } catch (Exception ignored) {
                return Response.status(500).build();
            }
        }
        return Response.status(400).build();
    }
}
