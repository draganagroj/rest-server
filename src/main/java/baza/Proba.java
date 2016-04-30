/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lekar;
import model.Nalaz;
import model.NalazPK;
import model.Opstina;
import model.Pacijent;
import model.Pregled;
import model.PregledPK;

import model.Tippregleda;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Dragana
 */
public class Proba {

    public static void main(String[] args) {

        Lekar L = Broker.vratiBrokera().vratiLekara(1);
        Pacijent p = Broker.vratiBrokera().vratiPacijenta("1111111111111");
        Pregled pr = new Pregled();
        Tippregleda tp = Broker.vratiBrokera().vratiTipovePregleda().get(0);
        pr.setTipPregleda(tp);
        PregledPK pk = new PregledPK(L.getLekarID(), p.getJMBGPacijenta());
        pr.setPregledPK(pk);
        pr.setLekar1(L);
        pr.setPacijent1(p);
        pr.setDatum(new java.sql.Date(new Date().getTime()));    
     
        NalazPK npk=new  NalazPK(L.getLekarID(), p.getJMBGPacijenta());
        Nalaz n=new Nalaz();
        n.setNalazPK(npk);
        n.setPredlozenaTerapija("bbbbb");
        n.setTegobe("ttttt");
        
        ArrayList<Nalaz> lista=new ArrayList<Nalaz>();
        lista.add(n);
        pr.setNalazList(lista);
        
 //       Broker.vratiBrokera().dodajPregled(pr);
       
       
    }
}
