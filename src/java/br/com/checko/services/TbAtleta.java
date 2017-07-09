/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checko.services;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Roberto Duré
 */
@Entity
@Table(name = "tb_atleta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAtleta.findAll", query = "SELECT t FROM TbAtleta t"),
    @NamedQuery(name = "TbAtleta.findByIdAtleta", query = "SELECT t FROM TbAtleta t WHERE t.idAtleta = :idAtleta"),
    @NamedQuery(name = "TbAtleta.findByNmAtleta", query = "SELECT t FROM TbAtleta t WHERE t.nmAtleta = :nmAtleta"),
    @NamedQuery(name = "TbAtleta.findByFlSexo", query = "SELECT t FROM TbAtleta t WHERE t.flSexo = :flSexo"),
    @NamedQuery(name = "TbAtleta.findByEmail", query = "SELECT t FROM TbAtleta t WHERE t.email = :email"),
    @NamedQuery(name = "TbAtleta.findByFoneFixo", query = "SELECT t FROM TbAtleta t WHERE t.foneFixo = :foneFixo"),
    @NamedQuery(name = "TbAtleta.findByFoneCelular", query = "SELECT t FROM TbAtleta t WHERE t.foneCelular = :foneCelular"),
    @NamedQuery(name = "TbAtleta.findByCdAtleta", query = "SELECT t FROM TbAtleta t WHERE t.cdAtleta = :cdAtleta")})
public class TbAtleta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ATLETA")
    private Integer idAtleta;
    @Basic(optional = false)
    @Column(name = "NM_ATLETA")
    private String nmAtleta;
    @Basic(optional = false)
    @Column(name = "FL_SEXO")
    private Character flSexo;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FONE_FIXO")
    private String foneFixo;
    @Column(name = "FONE_CELULAR")
    private String foneCelular;
    @Basic(optional = false)
    @Column(name = "CD_ATLETA")
    private int cdAtleta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAtleta")
    private Collection<TbInscricao> tbInscricaoCollection;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private TbCategoria idCategoria;
    @JoinColumn(name = "ID_CLUBE", referencedColumnName = "ID_CLUBE")
    @ManyToOne(optional = false)
    private TbClube idClube;
    @OneToMany(mappedBy = "idAtleta")
    private Collection<TbResultadoProva> tbResultadoProvaCollection;

    public TbAtleta() {
    }

    public TbAtleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
    }

    public TbAtleta(Integer idAtleta, String nmAtleta, Character flSexo, int cdAtleta) {
        this.idAtleta = idAtleta;
        this.nmAtleta = nmAtleta;
        this.flSexo = flSexo;
        this.cdAtleta = cdAtleta;
    }

    public Integer getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
    }

    public String getNmAtleta() {
        return nmAtleta;
    }

    public void setNmAtleta(String nmAtleta) {
        this.nmAtleta = nmAtleta;
    }

    public Character getFlSexo() {
        return flSexo;
    }

    public void setFlSexo(Character flSexo) {
        this.flSexo = flSexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getFoneCelular() {
        return foneCelular;
    }

    public void setFoneCelular(String foneCelular) {
        this.foneCelular = foneCelular;
    }

    public int getCdAtleta() {
        return cdAtleta;
    }

    public void setCdAtleta(int cdAtleta) {
        this.cdAtleta = cdAtleta;
    }

    @XmlTransient
    public Collection<TbInscricao> getTbInscricaoCollection() {
        return tbInscricaoCollection;
    }

    public void setTbInscricaoCollection(Collection<TbInscricao> tbInscricaoCollection) {
        this.tbInscricaoCollection = tbInscricaoCollection;
    }

    public TbCategoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(TbCategoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public TbClube getIdClube() {
        return idClube;
    }

    public void setIdClube(TbClube idClube) {
        this.idClube = idClube;
    }

    @XmlTransient
    public Collection<TbResultadoProva> getTbResultadoProvaCollection() {
        return tbResultadoProvaCollection;
    }

    public void setTbResultadoProvaCollection(Collection<TbResultadoProva> tbResultadoProvaCollection) {
        this.tbResultadoProvaCollection = tbResultadoProvaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtleta != null ? idAtleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbAtleta)) {
            return false;
        }
        TbAtleta other = (TbAtleta) object;
        if ((this.idAtleta == null && other.idAtleta != null) || (this.idAtleta != null && !this.idAtleta.equals(other.idAtleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbAtleta[ idAtleta=" + idAtleta + " ]";
    }
    
}
