/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dragana
 */

public class PregledWeb implements Serializable{
    
    private PregledPKWeb pregledpk;
    private Lekar lekar;
    private Pacijent pacijent;
    private Integer brojPregleda;
    private Tippregleda tippregleda;
    private Date datum;
    private List<NalazWeb> listaNalaza;

    public PregledWeb() {
    }

    
    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public Integer getBrojPregleda() {
        return brojPregleda;
    }

    public void setBrojPregleda(Integer brojPregleda) {
        this.brojPregleda = brojPregleda;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Tippregleda getTippregleda() {
        return tippregleda;
    }

    public void setTippregleda(Tippregleda tippregleda) {
        this.tippregleda = tippregleda;
    }

   
    @Override
    public String toString() {
        return brojPregleda+" "+lekar.getImeLekara()+" "+pacijent.getImePacijenta();
    }

    public PregledPKWeb getPregledpk() {
        return pregledpk;
    }

    public void setPregledpk(PregledPKWeb pregledpk) {
        this.pregledpk = pregledpk;
    }

    public List<NalazWeb> getListaNalaza() {
        return listaNalaza;
    }

    public void setListaNalaza(List<NalazWeb> listaNalaza) {
        this.listaNalaza = listaNalaza;
    }

}
