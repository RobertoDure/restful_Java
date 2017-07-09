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
@Table(name = "tb_cidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbCidades.findAll", query = "SELECT t FROM TbCidades t"),
    @NamedQuery(name = "TbCidades.findByIdCidade", query = "SELECT t FROM TbCidades t WHERE t.idCidade = :idCidade"),
    @NamedQuery(name = "TbCidades.findByNmCidade", query = "SELECT t FROM TbCidades t WHERE t.nmCidade = :nmCidade")})
public class TbCidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CIDADE")
    private Integer idCidade;
    @Column(name = "NM_CIDADE")
    private String nmCidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCidade")
    private Collection<TbEvento> tbEventoCollection;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne
    private TbEstados idEstado;

    public TbCidades() {
    }

    public TbCidades(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    @XmlTransient
    public Collection<TbEvento> getTbEventoCollection() {
        return tbEventoCollection;
    }

    public void setTbEventoCollection(Collection<TbEvento> tbEventoCollection) {
        this.tbEventoCollection = tbEventoCollection;
    }

    public TbEstados getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(TbEstados idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCidades)) {
            return false;
        }
        TbCidades other = (TbCidades) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbCidades[ idCidade=" + idCidade + " ]";
    }
    
}
