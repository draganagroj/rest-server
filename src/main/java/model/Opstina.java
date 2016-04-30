/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dragana
 */
@Entity
@Table(name = "opstina")

@NamedQueries({
    @NamedQuery(name = "Opstina.findAll", query = "SELECT o FROM Opstina o"),
    @NamedQuery(name = "Opstina.findBySifraOpstine", query = "SELECT o FROM Opstina o WHERE o.sifraOpstine = :sifraOpstine"),
    @NamedQuery(name = "Opstina.findByNazivOpstine", query = "SELECT o FROM Opstina o WHERE o.nazivOpstine = :nazivOpstine")})
public class Opstina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SifraOpstine")
    private Integer sifraOpstine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NazivOpstine")
    private String nazivOpstine;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opstina", fetch = FetchType.LAZY)
//    private List<Pacijent> pacijentList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opstina", fetch = FetchType.LAZY)
//    private List<Lekar> lekarList;

    public Opstina() {
    }

    public Opstina(Integer sifraOpstine) {
        this.sifraOpstine = sifraOpstine;
    }

    public Opstina(Integer sifraOpstine, String nazivOpstine) {
        this.sifraOpstine = sifraOpstine;
        this.nazivOpstine = nazivOpstine;
    }

    public Integer getSifraOpstine() {
        return sifraOpstine;
    }

    public void setSifraOpstine(Integer sifraOpstine) {
        this.sifraOpstine = sifraOpstine;
    }

    public String getNazivOpstine() {
        return nazivOpstine;
    }

    public void setNazivOpstine(String nazivOpstine) {
        this.nazivOpstine = nazivOpstine;
    }

//    @XmlTransient
//    public List<Pacijent> getPacijentList() {
//        return pacijentList;
//    }
//
//    public void setPacijentList(List<Pacijent> pacijentList) {
//        this.pacijentList = pacijentList;
//    }
//
//    @XmlTransient
//    public List<Lekar> getLekarList() {
//        return lekarList;
//    }
//
//    public void setLekarList(List<Lekar> lekarList) {
//        this.lekarList = lekarList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraOpstine != null ? sifraOpstine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opstina)) {
            return false;
        }
        Opstina other = (Opstina) object;
        if ((this.sifraOpstine == null && other.sifraOpstine != null) || (this.sifraOpstine != null && !this.sifraOpstine.equals(other.sifraOpstine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivOpstine;
    }
    
}
