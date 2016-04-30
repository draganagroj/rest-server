/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NamedQuery;
import model.Lekar;
import model.Nalaz;
import model.Opstina;
import model.Pacijent;
import model.Pregled;
import model.Tippregleda;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import baza.Test;
import model.NalazPK;
import model.NalazPKWeb;
import model.NalazWeb;
import model.PregledPK;
import model.PregledPKWeb;
import model.PregledWeb;
import org.hibernate.HibernateException;
/**
 *
 * @author Dragana
 */
public class Broker {

    public static Broker instance;

    public static Broker vratiBrokera() {
        if (instance == null) {
            instance = new Broker();
        }
        return instance;
    }

    public ArrayList<Lekar> vratiSveLekare() {
        Session session =Test.getSessionFactory().openSession();
        ArrayList<Lekar> lista = null;
        try {
            
            session.beginTransaction();
            Query q = session.createQuery("from Lekar");
            lista = (ArrayList<Lekar>) q.list();
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
        }
        finally{
        session.close();
        }
        return lista;
    }

    public Lekar vratiLekara(int lekarID) {
        Session session =Test.getSessionFactory().openSession();
        Lekar l = null;
        try {
            
            session.beginTransaction();
            l = (Lekar) session.get(Lekar.class, lekarID);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
        finally{
        session.close();}
        return l;
    }

    public boolean sacuvajIzmeneLekara(Lekar l) {
        boolean uspesno=false;
        Session session = Test.getSessionFactory().openSession();
        try {
            
            session.beginTransaction();
            Lekar lekar = (Lekar) session.get(Lekar.class, l.getLekarID());
            session.merge(l);
            session.getTransaction().commit();
            uspesno=true;
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
        finally{
        session.close();}
        return uspesno;
    }

    public boolean dodajPacijenta(Pacijent p) {
        boolean uspesno=false;
        Session session = Test.getSessionFactory().openSession();
        try {
            
            session.beginTransaction();
            session.persist(p);
            session.getTransaction().commit();
            uspesno=true;
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
        finally{
        session.close();}
        return uspesno;
    }

    public List<Pacijent> vratiSvePacijente() {
        Session session = Test.getSessionFactory().openSession();
        List<Pacijent> lista = null;
        try {
            
            session.beginTransaction();
            Query q = session.createQuery("from Pacijent");
            lista = (ArrayList<Pacijent>) q.list();
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
        finally{
        session.close();}
        return lista;
    }

    public Pacijent vratiPacijenta(String jmbg) {
        Session session =Test.getSessionFactory().openSession();
        Pacijent p = null;
        try {
            
            session.beginTransaction();
            p = (Pacijent) session.get(Pacijent.class, jmbg);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
        finally{
        session.close();}
        return p;
    }

    public boolean sacuvajIzmenePacijenta(Pacijent p) {
        boolean uspesno=false;
        Session session = Test.getSessionFactory().openSession();
        try {
            
            session.beginTransaction();
            Pacijent pacijent = (Pacijent) session.get(Pacijent.class, p.getJMBGPacijenta());
            session.merge(p);
            session.getTransaction().commit();
            uspesno=true;
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
       finally{
        session.close();
        }
        return uspesno;
    }

    public boolean obrisiPacijenta(Pacijent p) {
        boolean uspesno=false;
        Session session = Test.getSessionFactory().openSession();
        try {
             
            session.beginTransaction();
            session.delete(p);
            session.getTransaction().commit();
            uspesno=true;
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
        finally{
        session.close();}
        return uspesno;
    }

    public ArrayList<Opstina> vratiOpstine() {
        Session session =  Test.getSessionFactory().openSession();
        ArrayList<Opstina> opstine = null;
        try {
            
            session.beginTransaction();
            Query q = session.createQuery("from Opstina");
            opstine = (ArrayList<Opstina>) q.list();
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
        finally{
        session.close();}
        return opstine;
    }

    public ArrayList<Tippregleda> vratiTipovePregleda() {
        Session session = Test.getSessionFactory().openSession();
        ArrayList<Tippregleda> tipovi = null;
        try {
            
            session.beginTransaction();
            Query q = session.createQuery("from Tippregleda");
            tipovi = (ArrayList<Tippregleda>) q.list();
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
             session.getTransaction().rollback();
        }
        finally{
        session.close();}
        return tipovi;
    }

    public boolean dodajPregled(PregledWeb pr) {
        System.out.println(pr);
        int broj=vratiNajveceg()+1;
        System.out.println(pr.getPregledpk().getLekar());
        Pregled p=new Pregled();
        PregledPK pk=new PregledPK(pr.getLekar().getLekarID(), pr.getPacijent().getJMBGPacijenta());
        pk.setBrojPregleda(broj);
        p.setPregledPK(pk);
        p.setDatum(pr.getDatum());
        p.setPacijent1(pr.getPacijent());
        p.setLekar1(pr.getLekar());
        p.setTipPregleda(pr.getTippregleda());
        boolean uspesno=false;
        Session session =  Test.getSessionFactory().openSession();
//        try {
            session.beginTransaction();
//            
        
//      
            session.persist(p);
           
             List<NalazWeb> nalaziweb = pr.getListaNalaza();
//            
            List<Nalaz> lista=new ArrayList<Nalaz>();
            int br=1;
        if (!nalaziweb.isEmpty()) {
            for (NalazWeb nalazi1 : nalaziweb) {
                Nalaz n=new Nalaz();
                NalazPK npk=new NalazPK(pr.getLekar().getLekarID(), pr.getPacijent().getJMBGPacijenta());
                npk.setPregled(broj);
                npk.setRedniBroj(br);
                n.setNalazPK(npk);
                n.setPredlozenaTerapija(nalazi1.getPredlozenaTerapija());
                n.setTegobe(nalazi1.getTegobe());
                lista.add(n);
                br++;
            }
                for (Nalaz lista1 : lista) {
                session.persist(lista1);
              
                        
            }
                 session.getTransaction().commit();
            }
        
        uspesno=true;
//        }
    
//        catch (HibernateException hibernateException) {
//           session.getTransaction().rollback();
//        }
//        finally{
//              
      session.close();
//        }
 return uspesno;
         
    }

    public int vratiNajveceg() {
        int br;
        Session session = Test.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "SELECT MAX(BrojPregleda) FROM pregled";

        SQLQuery query = session.createSQLQuery(sql);
        br = (Integer) query.uniqueResult();

        
        session.close();
        return br;

    }

    public List<PregledWeb> vratiPregledePacijenta(String jmbg) {
        Session session = Test.getSessionFactory().openSession();
        ArrayList<Pregled> pregledi = null;
        try {
            session.beginTransaction();
            Query q = session.getNamedQuery("Pregled.findByPacijent").setString("pacijent", jmbg);
            List result = q.list();
            
            pregledi = (ArrayList<Pregled>) result;
              session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
//        for (Pregled pregledi1 : pregledi) {
//        Query qu = session.getNamedQuery("Nalaz.findByPregled").setInteger("pregled", pregledi1.getPregledPK().getBrojPregleda());
//        List result1 = qu.list();
//        ArrayList<Nalaz> nalazi=(ArrayList<Nalaz>) result1;
//        pregledi1.setNalazList(nalazi);

//        }
//      
      
           finally{   
        session.close();}
        List<PregledWeb> preglediweb=new ArrayList<PregledWeb>();
        for (Pregled pregled : pregledi) {
            PregledWeb prw=new PregledWeb();
            prw.setLekar(pregled.getLekar1());
            prw.setPacijent(pregled.getPacijent1());
            PregledPKWeb prwpk=new PregledPKWeb();
            prwpk.setBrojPregleda(pregled.getPregledPK().getBrojPregleda());
            prwpk.setLekar(pregled.getPregledPK().getLekar());
            prwpk.setPacijent(pregled.getPregledPK().getPacijent());
            prw.setBrojPregleda(pregled.getPregledPK().getBrojPregleda());
            prw.setDatum(pregled.getDatum());
            prw.setPregledpk(prwpk);
            prw.setTippregleda(pregled.getTipPregleda());
            preglediweb.add(prw);
        }
        return preglediweb;

    }
    public boolean obrisiPregled(Pregled p){
        boolean uspesno=false;
    Session session = Test.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(p);
            session.getTransaction().commit();
            uspesno=true;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally{
        session.close();
        }
        return uspesno;
    }
    public List<NalazWeb> vratiNalaze(int pregled){
    Session session = Test.getSessionFactory().openSession();
        ArrayList<Nalaz> nalazi = null;
        try {
            session.beginTransaction();
            
            Query q = session.getNamedQuery("Nalaz.findByPregled").setInteger("pregled", pregled);
            List result = q.list();
            nalazi = (ArrayList<Nalaz>) result;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
                    
        }
        finally{
        session.close();}
        List<NalazWeb> lista=new ArrayList<NalazWeb>();
        for (Nalaz nalaz : nalazi) {
            NalazWeb n=new NalazWeb();
            NalazPKWeb npk=new NalazPKWeb();
            npk.setBrojPregleda(nalaz.getNalazPK().getPregled());
            npk.setRedniBroj(nalaz.getNalazPK().getRedniBroj());
            npk.setLekar(nalaz.getNalazPK().getLekar());
            n.setNalazpk(npk);
            n.setTegobe(nalaz.getTegobe());
            n.setPredlozenaTerapija(nalaz.getPredlozenaTerapija());
           n.setRedniBroj(nalaz.getNalazPK().getRedniBroj());
            lista.add(n);
        }
        
        return lista;
    }
    
    
         
    public Pregled vratiPregled(int pregled){
    Session session = Test.getSessionFactory().openSession();
        Pregled p = null;
        try {
            session.beginTransaction();
            
            Query q = session.getNamedQuery("Pregled.findByBrojPregleda").setInteger("brojPregleda", pregled);
            p = (Pregled) q.list().get(0);
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally{
        session.close();
                
        }
        return p;
    }
}
