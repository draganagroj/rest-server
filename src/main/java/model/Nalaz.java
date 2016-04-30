/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.NalazPK;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.Pregled;

/**
 *
 * @author Dragana
 */
@Entity
@Table(name = "nalaz")

@NamedQueries({
    @NamedQuery(name = "Nalaz.findAll", query = "SELECT n FROM Nalaz n"),
    @NamedQuery(name = "Nalaz.findByLekar", query = "SELECT n FROM Nalaz n WHERE n.nalazPK.lekar = :lekar"),
    @NamedQuery(name = "Nalaz.findByPacijent", query = "SELECT n FROM Nalaz n WHERE n.nalazPK.pacijent = :pacijent"),
    @NamedQuery(name = "Nalaz.findByPregled", query = "SELECT n FROM Nalaz n WHERE n.nalazPK.pregled = :pregled"),
    @NamedQuery(name = "Nalaz.findByRedniBroj", query = "SELECT n FROM Nalaz n WHERE n.nalazPK.redniBroj = :redniBroj"),
    @NamedQuery(name = "Nalaz.findByTegobe", query = "SELECT n FROM Nalaz n WHERE n.tegobe = :tegobe"),
    @NamedQuery(name = "Nalaz.findByPredlozenaTerapija", query = "SELECT n FROM Nalaz n WHERE n.predlozenaTerapija = :predlozenaTerapija")})
public class Nalaz implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NalazPK nalazPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Tegobe")
    private String tegobe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PredlozenaTerapija")
    private String predlozenaTerapija;
    @JoinColumns({
        @JoinColumn(name = "Lekar", referencedColumnName = "Lekar", insertable = false, updatable = false),
        @JoinColumn(name = "Pacijent", referencedColumnName = "Pacijent", insertable = false, updatable = false),
        @JoinColumn(name = "Pregled", referencedColumnName = "BrojPregleda", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pregled pregled1;

    public Nalaz() {
    }

    public Nalaz(NalazPK nalazPK) {
        this.nalazPK = nalazPK;
    }

    public Nalaz(NalazPK nalazPK, String tegobe, String predlozenaTerapija) {
        this.nalazPK = nalazPK;
        this.tegobe = tegobe;
        this.predlozenaTerapija = predlozenaTerapija;
    }

    
    public NalazPK getNalazPK() {
        return nalazPK;
    }

    public void setNalazPK(NalazPK nalazPK) {
        this.nalazPK = nalazPK;
    }

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
    @XmlTransient
    public Pregled getPregled1() {
        return pregled1;
    }

    public void setPregled1(Pregled pregled1) {
        this.pregled1 = pregled1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nalazPK != null ? nalazPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nalaz)) {
            return false;
        }
        Nalaz other = (Nalaz) object;
        if ((this.nalazPK == null && other.nalazPK != null) || (this.nalazPK != null && !this.nalazPK.equals(other.nalazPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tegobe+ " "+predlozenaTerapija;
    }
    
}
