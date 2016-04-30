/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dragana
 */
@Entity
@Table(name = "pregled")

@NamedQueries({
    @NamedQuery(name = "Pregled.findAll", query = "SELECT p FROM Pregled p"),
    @NamedQuery(name = "Pregled.findByLekar", query = "SELECT p FROM Pregled p WHERE p.pregledPK.lekar = :lekar"),
    @NamedQuery(name = "Pregled.findByPacijent", query = "SELECT p FROM Pregled p WHERE p.pregledPK.pacijent= :pacijent"),
    @NamedQuery(name = "Pregled.findByBrojPregleda", query = "SELECT p FROM Pregled p WHERE p.pregledPK.brojPregleda = :brojPregleda"),
    @NamedQuery(name = "Pregled.findByDatum", query = "SELECT p FROM Pregled p WHERE p.datum = :datum")})
public class Pregled implements Serializable {
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregled1", fetch = FetchType.LAZY)
    private List<Nalaz> nalazList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PregledPK pregledPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @JoinColumn(name = "Lekar", referencedColumnName = "LekarID", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Lekar lekar1;
    @JoinColumn(name = "TipPregleda", referencedColumnName = "SifraTipaPregleda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tippregleda tipPregleda;
    @JoinColumn(name = "Pacijent", referencedColumnName = "JMBGPacijenta", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pacijent pacijent1;
  
    public Pregled() {
    }

    public Pregled(PregledPK pregledPK) {
        this.pregledPK = pregledPK;
    }

    public Pregled(PregledPK pregledPK, Date datum) {
        this.pregledPK = pregledPK;
        this.datum = datum;
    }

 
    public PregledPK getPregledPK() {
        return pregledPK;
    }

    public void setPregledPK(PregledPK pregledPK) {
        this.pregledPK = pregledPK;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Lekar getLekar1() {
        return lekar1;
    }

    public void setLekar1(Lekar lekar1) {
        this.lekar1 = lekar1;
    }

    public Tippregleda getTipPregleda() {
        return tipPregleda;
    }

    public void setTipPregleda(Tippregleda tipPregleda) {
        this.tipPregleda = tipPregleda;
    }

    public Pacijent getPacijent1() {
        return pacijent1;
    }

    public void setPacijent1(Pacijent pacijent1) {
        this.pacijent1 = pacijent1;
    }

    @XmlTransient
    public List<Nalaz> getNalazList() {
        return nalazList;
    }

    public void setNalazList(ArrayList<Nalaz> nalazList) {
        this.nalazList = nalazList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pregledPK != null ? pregledPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregled)) {
            return false;
        }
        Pregled other = (Pregled) object;
        if ((this.pregledPK == null && other.pregledPK != null) || (this.pregledPK != null && !this.pregledPK.equals(other.pregledPK))) {
            return false;
        }
        return true;
    }

   
   

  
    
}
