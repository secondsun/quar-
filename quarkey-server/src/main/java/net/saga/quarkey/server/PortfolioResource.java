package net.saga.quarkey.server;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import net.saga.quarkey.server.entity.PortfolioEntry;

@Path("/portfolio")
public class PortfolioResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<PortfolioEntry> get() {
        return PortfolioEntry.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public PortfolioEntry post(PortfolioEntry entry) {
        PortfolioEntry.persist(entry);
        return entry;
    }
}
