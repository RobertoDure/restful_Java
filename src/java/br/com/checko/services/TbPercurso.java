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
@Table(name = "tb_percurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPercurso.findAll", query = "SELECT t FROM TbPercurso t"),
    @NamedQuery(name = "TbPercurso.findByIdPercurso", query = "SELECT t FROM TbPercurso t WHERE t.idPercurso = :idPercurso"),
    @NamedQuery(name = "TbPercurso.findByIdDificuldade", query = "SELECT t FROM TbPercurso t WHERE t.idDificuldade = :idDificuldade")})
public class TbPercurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERCURSO")
    private Integer idPercurso;
    @Basic(optional = false)
    @Column(name = "ID_DIFICULDADE")
    private int idDificuldade;
    @OneToMany(mappedBy = "idPercurso")
    private Collection<TbPrisma> tbPrismaCollection;
    @JoinColumn(name = "ID_EVENTO", referencedColumnName = "ID_EVENTO")
    @ManyToOne(optional = false)
    private TbEvento idEvento;
    @JoinColumn(name = "ID_PROVA", referencedColumnName = "ID_PROVA")
    @ManyToOne(optional = false)
    private TbProva idProva;

    public TbPercurso() {
    }

    public TbPercurso(Integer idPercurso) {
        this.idPercurso = idPercurso;
    }

    public TbPercurso(Integer idPercurso, int idDificuldade) {
        this.idPercurso = idPercurso;
        this.idDificuldade = idDificuldade;
    }

    public Integer getIdPercurso() {
        return idPercurso;
    }

    public void setIdPercurso(Integer idPercurso) {
        this.idPercurso = idPercurso;
    }

    public int getIdDificuldade() {
        return idDificuldade;
    }

    public void setIdDificuldade(int idDificuldade) {
        this.idDificuldade = idDificuldade;
    }

    @XmlTransient
    public Collection<TbPrisma> getTbPrismaCollection() {
        return tbPrismaCollection;
    }

    public void setTbPrismaCollection(Collection<TbPrisma> tbPrismaCollection) {
        this.tbPrismaCollection = tbPrismaCollection;
    }

    public TbEvento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(TbEvento idEvento) {
        this.idEvento = idEvento;
    }

    public TbProva getIdProva() {
        return idProva;
    }

    public void setIdProva(TbProva idProva) {
        this.idProva = idProva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPercurso != null ? idPercurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPercurso)) {
            return false;
        }
        TbPercurso other = (TbPercurso) object;
        if ((this.idPercurso == null && other.idPercurso != null) || (this.idPercurso != null && !this.idPercurso.equals(other.idPercurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbPercurso[ idPercurso=" + idPercurso + " ]";
    }
    
}
