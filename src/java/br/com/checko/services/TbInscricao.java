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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roberto Duré
 */
@Entity
@Table(name = "tb_inscricao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbInscricao.findAll", query = "SELECT t FROM TbInscricao t"),
    @NamedQuery(name = "TbInscricao.findByIdInscricao", query = "SELECT t FROM TbInscricao t WHERE t.idInscricao = :idInscricao"),
    @NamedQuery(name = "TbInscricao.findByDtInscricao", query = "SELECT t FROM TbInscricao t WHERE t.dtInscricao = :dtInscricao")})
public class TbInscricao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INSCRICAO")
    private Integer idInscricao;
    @Basic(optional = false)
    @Column(name = "DT_INSCRICAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInscricao;
    @JoinColumn(name = "ID_ATLETA", referencedColumnName = "ID_ATLETA")
    @ManyToOne(optional = false)
    private TbAtleta idAtleta;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private TbCategoria idCategoria;
    @JoinColumn(name = "ID_EVENTO", referencedColumnName = "ID_EVENTO")
    @ManyToOne(optional = false)
    private TbEvento idEvento;

    public TbInscricao() {
    }

    public TbInscricao(Integer idInscricao) {
        this.idInscricao = idInscricao;
    }

    public TbInscricao(Integer idInscricao, Date dtInscricao) {
        this.idInscricao = idInscricao;
        this.dtInscricao = dtInscricao;
    }

    public Integer getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(Integer idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Date getDtInscricao() {
        return dtInscricao;
    }

    public void setDtInscricao(Date dtInscricao) {
        this.dtInscricao = dtInscricao;
    }

    public TbAtleta getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(TbAtleta idAtleta) {
        this.idAtleta = idAtleta;
    }

    public TbCategoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(TbCategoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public TbEvento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(TbEvento idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscricao != null ? idInscricao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInscricao)) {
            return false;
        }
        TbInscricao other = (TbInscricao) object;
        if ((this.idInscricao == null && other.idInscricao != null) || (this.idInscricao != null && !this.idInscricao.equals(other.idInscricao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbInscricao[ idInscricao=" + idInscricao + " ]";
    }
    
}
