/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Embeddable;



/**
 *
 * @author Dragana
 */
@Embeddable
public class NalazPKWeb {
    private int redniBroj;
    private String pacijent;
    private int lekar;
    private int brojPregleda;

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getPacijent() {
        return pacijent;
    }

    public void setPacijent(String pacijent) {
        this.pacijent = pacijent;
    }

    public int getLekar() {
        return lekar;
    }

    public void setLekar(int lekar) {
        this.lekar = lekar;
    }

    public int getBrojPregleda() {
        return brojPregleda;
    }

    public void setBrojPregleda(int brojPregleda) {
        this.brojPregleda = brojPregleda;
    }
}
