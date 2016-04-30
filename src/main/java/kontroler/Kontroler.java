/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import baza.Broker;
import java.util.List;
import model.Lekar;
import model.NalazWeb;
import model.Opstina;
import model.Pacijent;
import model.Pregled;
import model.PregledWeb;
import model.Tippregleda;

/**
 *
 * @author Dragana
 */
public class Kontroler {
    
   public static Kontroler instance;

    private Kontroler() {
    }
   
    public static Kontroler vratiInstancu(){
    
    if(instance==null)
        instance=new Kontroler();
    return instance;
            
    }
    public Lekar vratiLekara(int id){
    
     return Broker.vratiBrokera().vratiLekara(id);
    }
    
    public boolean izmeniLekara(Lekar l){
    return  Broker.vratiBrokera().sacuvajIzmeneLekara(l);
    }
    
    public List<Opstina> vratiOpstine(){
    return Broker.vratiBrokera().vratiOpstine();
    }
   public List<Tippregleda> vratiTipPregleda(){
   return Broker.vratiBrokera().vratiTipovePregleda();
   }
   
   public List<Pacijent> vratiListuPacijenata(){
    return Broker.vratiBrokera().vratiSvePacijente();
   }
   public boolean dodajPacijenta(Pacijent p){
    return Broker.vratiBrokera().dodajPacijenta(p);
   
   }
   public boolean sacuvajIzmenePacijenta(Pacijent p){
   return Broker.vratiBrokera().sacuvajIzmenePacijenta(p);
   }
   
   public Pacijent vratiPacijenta(String id){
   return Broker.vratiBrokera().vratiPacijenta(id);
   }
   public boolean obrisiPacijenta(String id){
    Pacijent p = Broker.vratiBrokera().vratiPacijenta(id);
   return Broker.vratiBrokera().obrisiPacijenta(p);
   }
   public List<PregledWeb> vratiPregledePacijenta(String pac){
    return Broker.vratiBrokera().vratiPregledePacijenta(pac);
   }
   public Pregled vratiPregled(int pr){
    return Broker.vratiBrokera().vratiPregled(pr);
   }
public void dodajPregled(PregledWeb p){
 Broker.vratiBrokera().dodajPregled(p);
}

public List<NalazWeb> vratiNalaze(int id){
 return Broker.vratiBrokera().vratiNalaze(id);
}
}
