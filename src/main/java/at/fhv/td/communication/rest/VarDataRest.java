package at.fhv.td.communication.rest;

import at.fhv.td.application.ClientController;
import at.fhv.td.application.TicketController;
import at.fhv.td.communication.dto.ClientDTO;
import at.fhv.td.communication.dto.TicketDTO;
import at.fhv.td.domain.assembler.ClientAssembler;
import at.fhv.td.domain.assembler.TicketAssembler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/data")
public class VarDataRest {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/clients")
    public Response getAllClients() {
        try {
            List<ClientDTO> clients = ClientController.getClients()
                    .stream()
                    .map(ClientAssembler::toClientDTO)
                    .collect(Collectors.toList());
            return Response.status(200).entity(clients).build();
        } catch (Exception ignored) {
            return Response.status(500).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tickets/{eventId}")
    public Response getTicketsOfEvent(@PathParam("eventId") int eventId) {
        try {
            if (eventId != 0) {
                List<TicketDTO> tickets = TicketController.getUnavailableTickets(eventId)
                        .stream()
                        .map(TicketAssembler::toTicketDTO)
                        .collect(Collectors.toList());
                return Response.status(200).entity(tickets).build();
            }
            throw new Exception();
        } catch (Exception ignored) {
            return Response.status(500).build();
        }
    }
}