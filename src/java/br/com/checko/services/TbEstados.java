/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checko.services;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "tb_estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEstados.findAll", query = "SELECT t FROM TbEstados t"),
    @NamedQuery(name = "TbEstados.findByIdEstado", query = "SELECT t FROM TbEstados t WHERE t.idEstado = :idEstado"),
    @NamedQuery(name = "TbEstados.findByNmEstado", query = "SELECT t FROM TbEstados t WHERE t.nmEstado = :nmEstado"),
    @NamedQuery(name = "TbEstados.findByDsSiglaEstado", query = "SELECT t FROM TbEstados t WHERE t.dsSiglaEstado = :dsSiglaEstado")})
public class TbEstados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO")
    private Integer idEstado;
    @Column(name = "NM_ESTADO")
    private String nmEstado;
    @Column(name = "DS_SIGLA_ESTADO")
    private String dsSiglaEstado;
    @OneToMany(mappedBy = "idEstado")
    private Collection<TbCidades> tbCidadesCollection;

    public TbEstados() {
    }

    public TbEstados(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    public String getDsSiglaEstado() {
        return dsSiglaEstado;
    }

    public void setDsSiglaEstado(String dsSiglaEstado) {
        this.dsSiglaEstado = dsSiglaEstado;
    }

    @XmlTransient
    public Collection<TbCidades> getTbCidadesCollection() {
        return tbCidadesCollection;
    }

    public void setTbCidadesCollection(Collection<TbCidades> tbCidadesCollection) {
        this.tbCidadesCollection = tbCidadesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEstados)) {
            return false;
        }
        TbEstados other = (TbEstados) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbEstados[ idEstado=" + idEstado + " ]";
    }
    
}
