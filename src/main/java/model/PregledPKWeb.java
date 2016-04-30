/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Embeddable;


/**
 *
 * @author Dragana
 */
@Embeddable
public class PregledPKWeb implements Serializable{
   private int brojPregleda; 
   private String pacijent;
   private int lekar;

    public PregledPKWeb() {
    }

    public int getBrojPregleda() {
        return brojPregleda;
    }

    public void setBrojPregleda(int brojPregleda) {
        this.brojPregleda = brojPregleda;
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
}
