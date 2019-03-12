package net.saga.quarkey.server;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.saga.quarkey.server.entity.PortfolioEntry;

@Path("/portfolio")
public class PortfolioResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PortfolioEntry> get() {
        PortfolioEntry portfolio = new PortfolioEntry();
        portfolio.name = "Quarkey";
        portfolio.description="A Quarkus and React based portfolio of my work.  You are looking at it right now.";
        portfolio.githubUrl="https://github.com/secondsun/Quarkey";
        portfolio.demoUrl="https://secondsun.dev";
     PortfolioEntry.persist(portfolio);   
        return PortfolioEntry.listAll();
    }
}