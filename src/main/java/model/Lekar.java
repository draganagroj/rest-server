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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dragana
 */
@Entity
@Table(name = "lekar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lekar.findAll", query = "SELECT l FROM Lekar l"),
    @NamedQuery(name = "Lekar.findByLekarID", query = "SELECT l FROM Lekar l WHERE l.lekarID = :lekarID"),
    @NamedQuery(name = "Lekar.findByJMBGLekara", query = "SELECT l FROM Lekar l WHERE l.jMBGLekara = :jMBGLekara"),
    @NamedQuery(name = "Lekar.findByImeLekara", query = "SELECT l FROM Lekar l WHERE l.imeLekara = :imeLekara"),
    @NamedQuery(name = "Lekar.findByPrezimeLekara", query = "SELECT l FROM Lekar l WHERE l.prezimeLekara = :prezimeLekara"),
    @NamedQuery(name = "Lekar.findByBrojLicence", query = "SELECT l FROM Lekar l WHERE l.brojLicence = :brojLicence"),
    @NamedQuery(name = "Lekar.findByNazivUlice", query = "SELECT l FROM Lekar l WHERE l.nazivUlice = :nazivUlice"),
    @NamedQuery(name = "Lekar.findByBrojZgrade", query = "SELECT l FROM Lekar l WHERE l.brojZgrade = :brojZgrade"),
    @NamedQuery(name = "Lekar.findByUserName", query = "SELECT l FROM Lekar l WHERE l.userName = :userName"),
    @NamedQuery(name = "Lekar.findByPassword", query = "SELECT l FROM Lekar l WHERE l.password = :password")})
public class Lekar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LekarID")
    private Integer lekarID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBGLekara")
    private String jMBGLekara;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ImeLekara")
    private String imeLekara;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PrezimeLekara")
    private String prezimeLekara;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BrojLicence")
    private int brojLicence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NazivUlice")
    private String nazivUlice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BrojZgrade")
    private int brojZgrade;
    @Size(max = 300)
    @Column(name = "UserName")
    private String userName;
    @Size(max = 300)
    @Column(name = "Password")
    private String password;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lekar", fetch = FetchType.LAZY)
//    private List<Pacijent> pacijentList;
    @JoinColumn(name = "Opstina", referencedColumnName = "SifraOpstine")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Opstina opstina;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lekar1", fetch = FetchType.LAZY)
//    private List<Pregled> pregledList;

    public Lekar() {
    }

    public Lekar(Integer lekarID) {
        this.lekarID = lekarID;
    }

    public Lekar(Integer lekarID, String jMBGLekara, String imeLekara, String prezimeLekara, int brojLicence, String nazivUlice, int brojZgrade) {
        this.lekarID = lekarID;
        this.jMBGLekara = jMBGLekara;
        this.imeLekara = imeLekara;
        this.prezimeLekara = prezimeLekara;
        this.brojLicence = brojLicence;
        this.nazivUlice = nazivUlice;
        this.brojZgrade = brojZgrade;
    }

    public Integer getLekarID() {
        return lekarID;
    }

    public void setLekarID(Integer lekarID) {
        this.lekarID = lekarID;
    }

    public String getJMBGLekara() {
        return jMBGLekara;
    }

    public void setJMBGLekara(String jMBGLekara) {
        this.jMBGLekara = jMBGLekara;
    }

    public String getImeLekara() {
        return imeLekara;
    }

    public void setImeLekara(String imeLekara) {
        this.imeLekara = imeLekara;
    }

    public String getPrezimeLekara() {
        return prezimeLekara;
    }

    public void setPrezimeLekara(String prezimeLekara) {
        this.prezimeLekara = prezimeLekara;
    }

    public int getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(int brojLicence) {
        this.brojLicence = brojLicence;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
//    public List<Pacijent> getPacijentList() {
//        return pacijentList;
//    }
//
//    public void setPacijentList(List<Pacijent> pacijentList) {
//        this.pacijentList = pacijentList;
//    }

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }

//    @XmlTransient
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
        hash += (lekarID != null ? lekarID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lekar)) {
            return false;
        }
        Lekar other = (Lekar) object;
        if ((this.lekarID == null && other.lekarID != null) || (this.lekarID != null && !this.lekarID.equals(other.lekarID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getLekarID()+" "+ getUserName()+ " "+getPassword() +" "+getImeLekara()+" "+getPrezimeLekara()+ " "+getJMBGLekara()+getNazivUlice()+" "+getBrojLicence()+" "+getBrojZgrade()+getOpstina().getNazivOpstine();
    }
    
}
