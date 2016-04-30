/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dragana
 */
@Embeddable
public class PregledPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Lekar")
    private int lekar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "Pacijent")
    private String pacijent;
    @Basic(optional = false)
    @NotNull 
    @Column(name = "BrojPregleda")
    private int brojPregleda;

    public PregledPK() {
    }

   

    public int getLekar() {
        return lekar;
    }

    public PregledPK(int lekar, String pacijent) {
        this.lekar = lekar;
        this.pacijent = pacijent;
    }

    public void setLekar(int lekar) {
        this.lekar = lekar;
    }

    public String getPacijent() {
        return pacijent;
    }

    public void setPacijent(String pacijent) {
        this.pacijent = pacijent;
    }

    public int getBrojPregleda() {
        return brojPregleda;
    }

    public void setBrojPregleda(int brojPregleda) {
        this.brojPregleda = brojPregleda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) lekar;
        hash += (pacijent != null ? pacijent.hashCode() : 0);
        hash += (int) brojPregleda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PregledPK)) {
            return false;
        }
        PregledPK other = (PregledPK) object;
        if (this.lekar != other.lekar) {
            return false;
        }
        if ((this.pacijent == null && other.pacijent != null) || (this.pacijent != null && !this.pacijent.equals(other.pacijent))) {
            return false;
        }
        if (this.brojPregleda != other.brojPregleda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.napredne.PregledPK[ lekar=" + lekar + ", pacijent=" + pacijent + ", brojPregleda=" + brojPregleda + " ]";
    }
    
}
