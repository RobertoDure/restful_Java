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
@Table(name = "tb_penalidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPenalidade.findAll", query = "SELECT t FROM TbPenalidade t"),
    @NamedQuery(name = "TbPenalidade.findByIdPenalidade", query = "SELECT t FROM TbPenalidade t WHERE t.idPenalidade = :idPenalidade"),
    @NamedQuery(name = "TbPenalidade.findByCdPenalidade", query = "SELECT t FROM TbPenalidade t WHERE t.cdPenalidade = :cdPenalidade"),
    @NamedQuery(name = "TbPenalidade.findBySiglaPenalidade", query = "SELECT t FROM TbPenalidade t WHERE t.siglaPenalidade = :siglaPenalidade"),
    @NamedQuery(name = "TbPenalidade.findByDsPenalidade", query = "SELECT t FROM TbPenalidade t WHERE t.dsPenalidade = :dsPenalidade")})
public class TbPenalidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PENALIDADE")
    private Integer idPenalidade;
    @Column(name = "CD_PENALIDADE")
    private Integer cdPenalidade;
    @Column(name = "SIGLA_PENALIDADE")
    private String siglaPenalidade;
    @Column(name = "DS_PENALIDADE")
    private String dsPenalidade;
    @OneToMany(mappedBy = "idPenalidade")
    private Collection<TbResultadoProva> tbResultadoProvaCollection;

    public TbPenalidade() {
    }

    public TbPenalidade(Integer idPenalidade) {
        this.idPenalidade = idPenalidade;
    }

    public Integer getIdPenalidade() {
        return idPenalidade;
    }

    public void setIdPenalidade(Integer idPenalidade) {
        this.idPenalidade = idPenalidade;
    }

    public Integer getCdPenalidade() {
        return cdPenalidade;
    }

    public void setCdPenalidade(Integer cdPenalidade) {
        this.cdPenalidade = cdPenalidade;
    }

    public String getSiglaPenalidade() {
        return siglaPenalidade;
    }

    public void setSiglaPenalidade(String siglaPenalidade) {
        this.siglaPenalidade = siglaPenalidade;
    }

    public String getDsPenalidade() {
        return dsPenalidade;
    }

    public void setDsPenalidade(String dsPenalidade) {
        this.dsPenalidade = dsPenalidade;
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
        hash += (idPenalidade != null ? idPenalidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPenalidade)) {
            return false;
        }
        TbPenalidade other = (TbPenalidade) object;
        if ((this.idPenalidade == null && other.idPenalidade != null) || (this.idPenalidade != null && !this.idPenalidade.equals(other.idPenalidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbPenalidade[ idPenalidade=" + idPenalidade + " ]";
    }
    
}
