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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "tb_prova")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProva.findAll", query = "SELECT t FROM TbProva t"),
    @NamedQuery(name = "TbProva.findByIdProva", query = "SELECT t FROM TbProva t WHERE t.idProva = :idProva"),
    @NamedQuery(name = "TbProva.findByDthrProvaInicio", query = "SELECT t FROM TbProva t WHERE t.dthrProvaInicio = :dthrProvaInicio"),
    @NamedQuery(name = "TbProva.findByDrhrProvaFim", query = "SELECT t FROM TbProva t WHERE t.drhrProvaFim = :drhrProvaFim"),
    @NamedQuery(name = "TbProva.findByDsProva", query = "SELECT t FROM TbProva t WHERE t.dsProva = :dsProva")})
public class TbProva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROVA")
    private Integer idProva;
    @Column(name = "DTHR_PROVA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dthrProvaInicio;
    @Column(name = "DRHR_PROVA_FIM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date drhrProvaFim;
    @Column(name = "DS_PROVA")
    private String dsProva;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbProva")
    private TbResultadoProva tbResultadoProva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProva")
    private Collection<TbPercurso> tbPercursoCollection;

    public TbProva() {
    }

    public TbProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Date getDthrProvaInicio() {
        return dthrProvaInicio;
    }

    public void setDthrProvaInicio(Date dthrProvaInicio) {
        this.dthrProvaInicio = dthrProvaInicio;
    }

    public Date getDrhrProvaFim() {
        return drhrProvaFim;
    }

    public void setDrhrProvaFim(Date drhrProvaFim) {
        this.drhrProvaFim = drhrProvaFim;
    }

    public String getDsProva() {
        return dsProva;
    }

    public void setDsProva(String dsProva) {
        this.dsProva = dsProva;
    }

    public TbResultadoProva getTbResultadoProva() {
        return tbResultadoProva;
    }

    public void setTbResultadoProva(TbResultadoProva tbResultadoProva) {
        this.tbResultadoProva = tbResultadoProva;
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
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProva)) {
            return false;
        }
        TbProva other = (TbProva) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbProva[ idProva=" + idProva + " ]";
    }
    
}
