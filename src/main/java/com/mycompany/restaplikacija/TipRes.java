/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restaplikacija;

import baza.Broker;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import kontroler.Kontroler;
import model.Tippregleda;

/**
 *
 * @author Dragana
 */
@Path("/tip")
public class TipRes {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tippregleda> vratiTip(){
    return Kontroler.vratiInstancu().vratiTipPregleda();
    }
}
