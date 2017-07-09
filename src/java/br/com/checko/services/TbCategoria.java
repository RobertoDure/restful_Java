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
@Table(name = "tb_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCategoria.findAll", query = "SELECT t FROM TbCategoria t"),
    @NamedQuery(name = "TbCategoria.findByIdCategoria", query = "SELECT t FROM TbCategoria t WHERE t.idCategoria = :idCategoria"),
    @NamedQuery(name = "TbCategoria.findByNmCategoria", query = "SELECT t FROM TbCategoria t WHERE t.nmCategoria = :nmCategoria")})
public class TbCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CATEGORIA")
    private Integer idCategoria;
    @Basic(optional = false)
    @Column(name = "NM_CATEGORIA")
    private String nmCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<TbInscricao> tbInscricaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<TbAtleta> tbAtletaCollection;

    public TbCategoria() {
    }

    public TbCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public TbCategoria(Integer idCategoria, String nmCategoria) {
        this.idCategoria = idCategoria;
        this.nmCategoria = nmCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNmCategoria() {
        return nmCategoria;
    }

    public void setNmCategoria(String nmCategoria) {
        this.nmCategoria = nmCategoria;
    }

    @XmlTransient
    public Collection<TbInscricao> getTbInscricaoCollection() {
        return tbInscricaoCollection;
    }

    public void setTbInscricaoCollection(Collection<TbInscricao> tbInscricaoCollection) {
        this.tbInscricaoCollection = tbInscricaoCollection;
    }

    @XmlTransient
    public Collection<TbAtleta> getTbAtletaCollection() {
        return tbAtletaCollection;
    }

    public void setTbAtletaCollection(Collection<TbAtleta> tbAtletaCollection) {
        this.tbAtletaCollection = tbAtletaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCategoria)) {
            return false;
        }
        TbCategoria other = (TbCategoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbCategoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
