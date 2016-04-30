/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restaplikacija;

import baza.Broker;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import kontroler.Kontroler;
import model.Pregled;
import model.PregledWeb;

/**
 *
 * @author Dragana
 */
@Path("/")
public class PreglediResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
 public List<PregledWeb> vratiPreglede(@PathParam("pacijentiD") String pac){

 return Kontroler.vratiInstancu().vratiPregledePacijenta(pac);
  }
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{preglediD}")
 public Pregled vratiPreglede(@PathParam("preglediD") int pr){
     
 return Kontroler.vratiInstancu().vratiPregled(pr);
  }
 
 @POST
 @Consumes(MediaType.APPLICATION_JSON)
  public void dodajPregled(PregledWeb p){
      System.out.println(p);
       Kontroler.vratiInstancu().dodajPregled(p);
    }
 
 
 @Path("/{preglediD}/nalazi")
  public NalaziResource vratiNalaze(){
  
  return new NalaziResource();
  }
}
