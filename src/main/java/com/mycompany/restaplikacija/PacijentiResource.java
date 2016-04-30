/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restaplikacija;

import baza.Broker;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import kontroler.Kontroler;
import model.Pacijent;

/**
 *
 * @author Dragana
 */
@Path("pacijenti")
public class PacijentiResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pacijent> vratiListuPacijenata() {
       return Kontroler.vratiInstancu().vratiListuPacijenata();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String dodajPacijenta(Pacijent p) {
        boolean uspesno =Kontroler.vratiInstancu().dodajPacijenta(p);
        if (uspesno) {
            return "uspesno";
        } else {
            return "neuspesno";
        }
    }

    @PUT
    @Path("/{pacijentiD}")
    @Consumes(MediaType.APPLICATION_JSON)

    public String izmeniPacijenta(@PathParam("pacijentiD") String id, Pacijent p) {
        p.setJMBGPacijenta(id);
        boolean uspesno=Kontroler.vratiInstancu().sacuvajIzmenePacijenta(p);
       if(uspesno){
           return "uspesno";

       }
       else{
       
       return "neuspeno";
       }

    }

    @GET
    @Path("/{pacijentiD}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pacijent vratiPacijenta(@PathParam("pacijentiD") String id) {
        return Kontroler.vratiInstancu().vratiPacijenta(id);
    }

    @DELETE
    @Path("/{pacijentiD}")
    @Produces(MediaType.APPLICATION_JSON)
    public String obrisiPacijenta(@PathParam("pacijentiD") String id) {   
       boolean uspesno=Kontroler.vratiInstancu().obrisiPacijenta(id);
       if(uspesno){
       return "uspesno";
       
       }
       else{
       return "neuspesno";}
    }

    @Path("/{pacijentiD}/pregledi")
    public PreglediResource pregledi() {
        return new PreglediResource();
    }

}
