package com.mycompany.restaplikacija;

import baza.Broker;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import kontroler.Kontroler;
import model.Lekar;

@Path("lekari")
public class LekariResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lekar> vratiLekare() {
        return Broker.vratiBrokera().vratiSveLekare();

    }

    @Path("/{lekarId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Lekar vratiLekara(@PathParam("lekarId") int id) {

        return Kontroler.vratiInstancu().vratiLekara(id);

    }

    @Path("/{lekarId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
 
    public String izmeniLekara(@PathParam("lekarId") int id, Lekar l) {
        l.setLekarID(id);
        boolean uspesno =Kontroler.vratiInstancu().izmeniLekara(l);
        if (uspesno) {
            return "uspesno";
        } else {
            return "neuspesno";
        }
    }
}
