/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checko.services;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roberto Duré
 */
@Entity
@Table(name = "tb_resultado_prova")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbResultadoProva.findAll", query = "SELECT t FROM TbResultadoProva t"),
    @NamedQuery(name = "TbResultadoProva.findByIdProva", query = "SELECT t FROM TbResultadoProva t WHERE t.idProva = :idProva"),
    @NamedQuery(name = "TbResultadoProva.findByTmpGasto", query = "SELECT t FROM TbResultadoProva t WHERE t.tmpGasto = :tmpGasto")})
public class TbResultadoProva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROVA")
    private Integer idProva;
    @Column(name = "TMP_GASTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmpGasto;
    @JoinColumn(name = "ID_ATLETA", referencedColumnName = "ID_ATLETA")
    @ManyToOne
    private TbAtleta idAtleta;
    @JoinColumn(name = "ID_EVENTO", referencedColumnName = "ID_EVENTO")
    @ManyToOne
    private TbEvento idEvento;
    @JoinColumn(name = "ID_PENALIDADE", referencedColumnName = "ID_PENALIDADE")
    @ManyToOne
    private TbPenalidade idPenalidade;
    @JoinColumn(name = "ID_PROVA", referencedColumnName = "ID_PROVA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TbProva tbProva;

    public TbResultadoProva() {
    }

    public TbResultadoProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Date getTmpGasto() {
        return tmpGasto;
    }

    public void setTmpGasto(Date tmpGasto) {
        this.tmpGasto = tmpGasto;
    }

    public TbAtleta getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(TbAtleta idAtleta) {
        this.idAtleta = idAtleta;
    }

    public TbEvento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(TbEvento idEvento) {
        this.idEvento = idEvento;
    }

    public TbPenalidade getIdPenalidade() {
        return idPenalidade;
    }

    public void setIdPenalidade(TbPenalidade idPenalidade) {
        this.idPenalidade = idPenalidade;
    }

    public TbProva getTbProva() {
        return tbProva;
    }

    public void setTbProva(TbProva tbProva) {
        this.tbProva = tbProva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbResultadoProva)) {
            return false;
        }
        TbResultadoProva other = (TbResultadoProva) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbResultadoProva[ idProva=" + idProva + " ]";
    }
    
}
