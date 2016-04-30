/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.EmbeddedId;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dragana
 */
@XmlRootElement
public class NalazWeb {
    private Lekar lekar;
 private String tegobe;
    private String predlozenaTerapija;
     @EmbeddedId
    private NalazPKWeb nalazpk;

    public String getTegobe() {
        return tegobe;
    }

    public void setTegobe(String tegobe) {
        this.tegobe = tegobe;
    }

    public String getPredlozenaTerapija() {
        return predlozenaTerapija;
    }

    public void setPredlozenaTerapija(String predlozenaTerapija) {
        this.predlozenaTerapija = predlozenaTerapija;
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

    public PregledWeb getPregled() {
        return pregled;
    }

    public void setPregled(PregledWeb pregled) {
        this.pregled = pregled;
    }

    public Integer getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(Integer redniBroj) {
        this.redniBroj = redniBroj;
    }
    private Pacijent pacijent;
    private PregledWeb pregled;
    private Integer redniBroj;
@XmlTransient
    public NalazPKWeb getNalazpk() {
        return nalazpk;
    }

    public void setNalazpk(NalazPKWeb nalazpk) {
        this.nalazpk = nalazpk;
    }

}
