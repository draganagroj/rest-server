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
import org.hibernate.boot.registry.selector.StrategyRegistration;

/**
 *
 * @author Dragana
 */
@Embeddable
public class NalazPK implements Serializable {
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
    @Column(name = "Pregled")
    private int pregled;
    @Basic(optional = false)
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "RedniBroj")
    private int redniBroj;

    public NalazPK() {
    }

    public NalazPK(int lekar, String pacijent) {
        this.lekar = lekar;
        this.pacijent = pacijent;
        
    }

    public NalazPK(int lekar, String pacijent, int pregled) {
        this.lekar = lekar;
        this.pacijent = pacijent;
        this.pregled = pregled;
    }

    public int getLekar() {
        return lekar;
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

    public int getPregled() {
        return pregled;
    }

    public void setPregled(int pregled) {
        this.pregled = pregled;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) lekar;
        hash += (pacijent != null ? pacijent.hashCode() : 0);
        hash += (int) pregled;
        hash += (int) redniBroj;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NalazPK)) {
            return false;
        }
        NalazPK other = (NalazPK) object;
        if (this.lekar != other.lekar) {
            return false;
        }
        if ((this.pacijent == null && other.pacijent != null) || (this.pacijent != null && !this.pacijent.equals(other.pacijent))) {
            return false;
        }
        if (this.pregled != other.pregled) {
            return false;
        }
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "baza.NalazPK[ lekar=" + lekar + ", pacijent=" + pacijent + ", pregled=" + pregled + ", redniBroj=" + redniBroj + " ]";
    }
    
}
