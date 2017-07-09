/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checko.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Roberto Duré
 */
@Entity
@Table(name = "tb_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEvento.findAll", query = "SELECT t FROM TbEvento t"),
    @NamedQuery(name = "TbEvento.findByIdEvento", query = "SELECT t FROM TbEvento t WHERE t.idEvento = :idEvento"),
    @NamedQuery(name = "TbEvento.findByNmEvento", query = "SELECT t FROM TbEvento t WHERE t.nmEvento = :nmEvento"),
    @NamedQuery(name = "TbEvento.findByDsEvento", query = "SELECT t FROM TbEvento t WHERE t.dsEvento = :dsEvento"),
    @NamedQuery(name = "TbEvento.findByTpEvento", query = "SELECT t FROM TbEvento t WHERE t.tpEvento = :tpEvento"),
    @NamedQuery(name = "TbEvento.findByDtEvento", query = "SELECT t FROM TbEvento t WHERE t.dtEvento = :dtEvento"),
    @NamedQuery(name = "TbEvento.findByPpEvento", query = "SELECT t FROM TbEvento t WHERE t.ppEvento = :ppEvento")})
public class TbEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EVENTO")
    private Integer idEvento;
    @Basic(optional = false)
    @Column(name = "NM_EVENTO")
    private String nmEvento;
    @Column(name = "DS_EVENTO")
    private String dsEvento;
    @Basic(optional = false)
    @Column(name = "TP_EVENTO")
    private String tpEvento;
    @Basic(optional = false)
    @Column(name = "DT_EVENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEvento;
    @Basic(optional = false)
    @Column(name = "PP_EVENTO")
    private String ppEvento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private Collection<TbInscricao> tbInscricaoCollection;
    @JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE")
    @ManyToOne(optional = false)
    private TbCidades idCidade;
    @OneToMany(mappedBy = "idEvento")
    private Collection<TbResultadoProva> tbResultadoProvaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvento")
    private Collection<TbPercurso> tbPercursoCollection;

    public TbEvento() {
    }

    public TbEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public TbEvento(Integer idEvento, String nmEvento, String tpEvento, Date dtEvento, String ppEvento) {
        this.idEvento = idEvento;
        this.nmEvento = nmEvento;
        this.tpEvento = tpEvento;
        this.dtEvento = dtEvento;
        this.ppEvento = ppEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNmEvento() {
        return nmEvento;
    }

    public void setNmEvento(String nmEvento) {
        this.nmEvento = nmEvento;
    }

    public String getDsEvento() {
        return dsEvento;
    }

    public void setDsEvento(String dsEvento) {
        this.dsEvento = dsEvento;
    }

    public String getTpEvento() {
        return tpEvento;
    }

    public void setTpEvento(String tpEvento) {
        this.tpEvento = tpEvento;
    }

    public Date getDtEvento() {
        return dtEvento;
    }

    public void setDtEvento(Date dtEvento) {
        this.dtEvento = dtEvento;
    }

    public String getPpEvento() {
        return ppEvento;
    }

    public void setPpEvento(String ppEvento) {
        this.ppEvento = ppEvento;
    }

    @XmlTransient
    public Collection<TbInscricao> getTbInscricaoCollection() {
        return tbInscricaoCollection;
    }

    public void setTbInscricaoCollection(Collection<TbInscricao> tbInscricaoCollection) {
        this.tbInscricaoCollection = tbInscricaoCollection;
    }

    public TbCidades getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(TbCidades idCidade) {
        this.idCidade = idCidade;
    }

    @XmlTransient
    public Collection<TbResultadoProva> getTbResultadoProvaCollection() {
        return tbResultadoProvaCollection;
    }

    public void setTbResultadoProvaCollection(Collection<TbResultadoProva> tbResultadoProvaCollection) {
        this.tbResultadoProvaCollection = tbResultadoProvaCollection;
    }

    @XmlTransient
    public Collection<TbPercurso> getTbPercursoCollection() {
        return tbPercursoCollection;
    }

    public void setTbPercursoCollection(Collection<TbPercurso> tbPercursoCollection) {
        this.tbPercursoCollection = tbPercursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEvento)) {
            return false;
        }
        TbEvento other = (TbEvento) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbEvento[ idEvento=" + idEvento + " ]";
    }
    
}
