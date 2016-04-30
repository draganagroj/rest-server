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
@Table(name = "tippregleda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tippregleda.findAll", query = "SELECT t FROM Tippregleda t"),
    @NamedQuery(name = "Tippregleda.findBySifraTipaPregleda", query = "SELECT t FROM Tippregleda t WHERE t.sifraTipaPregleda = :sifraTipaPregleda"),
    @NamedQuery(name = "Tippregleda.findByNazivTipaPregleda", query = "SELECT t FROM Tippregleda t WHERE t.nazivTipaPregleda = :nazivTipaPregleda")})
public class Tippregleda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SifraTipaPregleda")
    private Integer sifraTipaPregleda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NazivTipaPregleda")
    private String nazivTipaPregleda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipPregleda", fetch = FetchType.LAZY)
    private List<Pregled> pregledList;

    public Tippregleda() {
    }

    public Tippregleda(Integer sifraTipaPregleda) {
        this.sifraTipaPregleda = sifraTipaPregleda;
    }

    public Tippregleda(Integer sifraTipaPregleda, String nazivTipaPregleda) {
        this.sifraTipaPregleda = sifraTipaPregleda;
        this.nazivTipaPregleda = nazivTipaPregleda;
    }

    public Integer getSifraTipaPregleda() {
        return sifraTipaPregleda;
    }

    public void setSifraTipaPregleda(Integer sifraTipaPregleda) {
        this.sifraTipaPregleda = sifraTipaPregleda;
    }

    public String getNazivTipaPregleda() {
        return nazivTipaPregleda;
    }

    public void setNazivTipaPregleda(String nazivTipaPregleda) {
        this.nazivTipaPregleda = nazivTipaPregleda;
    }

    @XmlTransient
    public List<Pregled> getPregledList() {
        return pregledList;
    }

    public void setPregledList(List<Pregled> pregledList) {
        this.pregledList = pregledList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sifraTipaPregleda != null ? sifraTipaPregleda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tippregleda)) {
            return false;
        }
        Tippregleda other = (Tippregleda) object;
        if ((this.sifraTipaPregleda == null && other.sifraTipaPregleda != null) || (this.sifraTipaPregleda != null && !this.sifraTipaPregleda.equals(other.sifraTipaPregleda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivTipaPregleda;
    }
    
}
