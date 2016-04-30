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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Dragana
 */
@Entity
@Table(name = "pacijent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacijent.findAll", query = "SELECT p FROM Pacijent p"),
    @NamedQuery(name = "Pacijent.findByJMBGPacijenta", query = "SELECT p FROM Pacijent p WHERE p.jMBGPacijenta = :jMBGPacijenta"),
    @NamedQuery(name = "Pacijent.findByImePacijenta", query = "SELECT p FROM Pacijent p WHERE p.imePacijenta = :imePacijenta"),
    @NamedQuery(name = "Pacijent.findByPrezimePacijenta", query = "SELECT p FROM Pacijent p WHERE p.prezimePacijenta = :prezimePacijenta"),
    @NamedQuery(name = "Pacijent.findByNazivUlice", query = "SELECT p FROM Pacijent p WHERE p.nazivUlice = :nazivUlice"),
    @NamedQuery(name = "Pacijent.findByBrojZgrade", query = "SELECT p FROM Pacijent p WHERE p.brojZgrade = :brojZgrade")})
public class Pacijent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBGPacijenta")
    private String jMBGPacijenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ImePacijenta")
    private String imePacijenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PrezimePacijenta")
    private String prezimePacijenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NazivUlice")
    private String nazivUlice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BrojZgrade")
    private int brojZgrade;
    @JoinColumn(name = "Lekar", referencedColumnName = "LekarID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Lekar lekar;
    @JoinColumn(name = "Opstina", referencedColumnName = "SifraOpstine")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Opstina opstina;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacijent1", fetch = FetchType.LAZY)
//    private List<Pregled> pregledList;

    public Pacijent() {
    }

    public Pacijent(String jMBGPacijenta) {
        this.jMBGPacijenta = jMBGPacijenta;
    }

    public Pacijent(String jMBGPacijenta, String imePacijenta, String prezimePacijenta, String nazivUlice, int brojZgrade) {
        this.jMBGPacijenta = jMBGPacijenta;
        this.imePacijenta = imePacijenta;
        this.prezimePacijenta = prezimePacijenta;
        this.nazivUlice = nazivUlice;
        this.brojZgrade = brojZgrade;
    }

    public String getJMBGPacijenta() {
        return jMBGPacijenta;
    }

    public void setJMBGPacijenta(String jMBGPacijenta) {
        this.jMBGPacijenta = jMBGPacijenta;
    }

    public String getImePacijenta() {
        return imePacijenta;
    }

    public void setImePacijenta(String imePacijenta) {
        this.imePacijenta = imePacijenta;
    }

    public String getPrezimePacijenta() {
        return prezimePacijenta;
    }

    public void setPrezimePacijenta(String prezimePacijenta) {
        this.prezimePacijenta = prezimePacijenta;
    }

    public String getNazivUlice() {
        return nazivUlice;
    }

    public void setNazivUlice(String nazivUlice) {
        this.nazivUlice = nazivUlice;
    }

    public int getBrojZgrade() {
        return brojZgrade;
    }

    public void setBrojZgrade(int brojZgrade) {
        this.brojZgrade = brojZgrade;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }
//
    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }
//
//    public List<Pregled> getPregledList() {
//        return pregledList;
//    }
//
//    public void setPregledList(List<Pregled> pregledList) {
//        this.pregledList = pregledList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jMBGPacijenta != null ? jMBGPacijenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacijent)) {
            return false;
        }
        Pacijent other = (Pacijent) object;
        if ((this.jMBGPacijenta == null && other.jMBGPacijenta != null) || (this.jMBGPacijenta != null && !this.jMBGPacijenta.equals(other.jMBGPacijenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imePacijenta+ " "+prezimePacijenta+" "+jMBGPacijenta+" "+nazivUlice+ " "+getJMBGPacijenta();
    }
    
}
