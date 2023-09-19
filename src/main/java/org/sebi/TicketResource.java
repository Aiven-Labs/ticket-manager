package org.sebi;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("tickets")
public class TicketResource {

    @GET
    public List<Ticket> tickets() {
        return Ticket.listAll();
    }

    @POST
    @Transactional
    public Response createTicket(Ticket ticket) {
        ticket.persist();
        return Response.status(Status.CREATED).entity(ticket).build();
    }
    
}
