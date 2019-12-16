package at.fhv.td.communication.rest;

import at.fhv.td.application.EventController;
import at.fhv.td.communication.dto.EventDetailedViewDTO;
import at.fhv.td.domain.assembler.EventDetailAssembler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
public class SearchEventsRest {
    /**
     * Searches for events with params: /searchEvents?artist=boing&eventName=blubb
     *
     * @param year               year to search for, default is actual year
     * @param month              month to search for, default is actual month
     * @param day                day to search for, default is actual day
     * @param searchingArtist    artist to search for
     * @param searchingEventName eventName to search for
     * @param searchingLocation  location to search for
     * @return
     */
    @GET
    public Response searchForEvents(
            @QueryParam("y") @DefaultValue("0") int year,
            @QueryParam("m") @DefaultValue("0") int month,
            @QueryParam("d") @DefaultValue("0") int day,
            @QueryParam("artist") @DefaultValue("") String searchingArtist,
            @QueryParam("eventName") @DefaultValue("") String searchingEventName,
            @QueryParam("location") @DefaultValue("") String searchingLocation) {
        if (year == 0) {
            year = LocalDate.now().getYear();
        }
        if (month == 0) {
            month = LocalDate.now().getMonthValue();
        }
        if (day == 0) {
            day = LocalDate.now().getDayOfMonth();
        }

        try {
            List<EventDetailedViewDTO> events = EventController
                    .searchForEvents(searchingEventName, searchingArtist, searchingLocation, LocalDate.of(year, month, day))
                    .stream()
                    .map(EventDetailAssembler::toEventDetailedViewDTO)
                    .collect(Collectors.toList());
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(events).build();
        } catch (Exception ignored) {
            return Response.status(500).build();
        }
    }

    @GET
    @Path("/{eventId}")
    public Response getTicketsOfEvent(@PathParam("eventId") int eventId) {
        try {
            EventDetailedViewDTO event = EventDetailAssembler.toEventDetailedViewDTO(EventController.getEvent(Integer.toUnsignedLong(eventId)));
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(event).build();
        } catch (Exception ignored) {
            return Response.status(500).build();
        }
    }
}
