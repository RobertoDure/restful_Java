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
@Table(name = "tb_clube")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbClube.findAll", query = "SELECT t FROM TbClube t"),
    @NamedQuery(name = "TbClube.findByIdClube", query = "SELECT t FROM TbClube t WHERE t.idClube = :idClube"),
    @NamedQuery(name = "TbClube.findByNmClube", query = "SELECT t FROM TbClube t WHERE t.nmClube = :nmClube"),
    @NamedQuery(name = "TbClube.findByNmSiglaClube", query = "SELECT t FROM TbClube t WHERE t.nmSiglaClube = :nmSiglaClube")})
public class TbClube implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLUBE")
    private Integer idClube;
    @Column(name = "NM_CLUBE")
    private String nmClube;
    @Column(name = "NM_SIGLA_CLUBE")
    private String nmSiglaClube;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClube")
    private Collection<TbAtleta> tbAtletaCollection;

    public TbClube() {
    }

    public TbClube(Integer idClube) {
        this.idClube = idClube;
    }

    public Integer getIdClube() {
        return idClube;
    }

    public void setIdClube(Integer idClube) {
        this.idClube = idClube;
    }

    public String getNmClube() {
        return nmClube;
    }

    public void setNmClube(String nmClube) {
        this.nmClube = nmClube;
    }

    public String getNmSiglaClube() {
        return nmSiglaClube;
    }

    public void setNmSiglaClube(String nmSiglaClube) {
        this.nmSiglaClube = nmSiglaClube;
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
        hash += (idClube != null ? idClube.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbClube)) {
            return false;
        }
        TbClube other = (TbClube) object;
        if ((this.idClube == null && other.idClube != null) || (this.idClube != null && !this.idClube.equals(other.idClube))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbClube[ idClube=" + idClube + " ]";
    }
    
}
