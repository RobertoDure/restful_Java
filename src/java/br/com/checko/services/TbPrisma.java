/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checko.services;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Roberto Duré
 */
@Entity
@Table(name = "tb_prisma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPrisma.findAll", query = "SELECT t FROM TbPrisma t"),
    @NamedQuery(name = "TbPrisma.findByIdPrisma", query = "SELECT t FROM TbPrisma t WHERE t.idPrisma = :idPrisma"),
    @NamedQuery(name = "TbPrisma.findByCdPronto", query = "SELECT t FROM TbPrisma t WHERE t.cdPronto = :cdPronto"),
    @NamedQuery(name = "TbPrisma.findByCdZona", query = "SELECT t FROM TbPrisma t WHERE t.cdZona = :cdZona"),
    @NamedQuery(name = "TbPrisma.findByCdCoordenadaE", query = "SELECT t FROM TbPrisma t WHERE t.cdCoordenadaE = :cdCoordenadaE"),
    @NamedQuery(name = "TbPrisma.findByCdCoordenadaN", query = "SELECT t FROM TbPrisma t WHERE t.cdCoordenadaN = :cdCoordenadaN"),
    @NamedQuery(name = "TbPrisma.findByFlNs", query = "SELECT t FROM TbPrisma t WHERE t.flNs = :flNs"),
    @NamedQuery(name = "TbPrisma.findByCdCoordenadaH", query = "SELECT t FROM TbPrisma t WHERE t.cdCoordenadaH = :cdCoordenadaH"),
    @NamedQuery(name = "TbPrisma.findByNrIndicadorPosicao", query = "SELECT t FROM TbPrisma t WHERE t.nrIndicadorPosicao = :nrIndicadorPosicao")})
public class TbPrisma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRISMA")
    private Integer idPrisma;
    @Column(name = "CD_PRONTO")
    private String cdPronto;
    @Column(name = "CD_ZONA")
    private String cdZona;
    @Column(name = "CD_COORDENADA_E")
    private String cdCoordenadaE;
    @Column(name = "CD_COORDENADA_N")
    private String cdCoordenadaN;
    @Column(name = "FL_NS")
    private Character flNs;
    @Column(name = "CD_COORDENADA_H")
    private String cdCoordenadaH;
    @Column(name = "NR_INDICADOR_POSICAO")
    private String nrIndicadorPosicao;
    @JoinColumn(name = "ID_PERCURSO", referencedColumnName = "ID_PERCURSO")
    @ManyToOne
    private TbPercurso idPercurso;

    public TbPrisma() {
    }

    public TbPrisma(Integer idPrisma) {
        this.idPrisma = idPrisma;
    }

    public Integer getIdPrisma() {
        return idPrisma;
    }

    public void setIdPrisma(Integer idPrisma) {
        this.idPrisma = idPrisma;
    }

    public String getCdPronto() {
        return cdPronto;
    }

    public void setCdPronto(String cdPronto) {
        this.cdPronto = cdPronto;
    }

    public String getCdZona() {
        return cdZona;
    }

    public void setCdZona(String cdZona) {
        this.cdZona = cdZona;
    }

    public String getCdCoordenadaE() {
        return cdCoordenadaE;
    }

    public void setCdCoordenadaE(String cdCoordenadaE) {
        this.cdCoordenadaE = cdCoordenadaE;
    }

    public String getCdCoordenadaN() {
        return cdCoordenadaN;
    }

    public void setCdCoordenadaN(String cdCoordenadaN) {
        this.cdCoordenadaN = cdCoordenadaN;
    }

    public Character getFlNs() {
        return flNs;
    }

    public void setFlNs(Character flNs) {
        this.flNs = flNs;
    }

    public String getCdCoordenadaH() {
        return cdCoordenadaH;
    }

    public void setCdCoordenadaH(String cdCoordenadaH) {
        this.cdCoordenadaH = cdCoordenadaH;
    }

    public String getNrIndicadorPosicao() {
        return nrIndicadorPosicao;
    }

    public void setNrIndicadorPosicao(String nrIndicadorPosicao) {
        this.nrIndicadorPosicao = nrIndicadorPosicao;
    }

    public TbPercurso getIdPercurso() {
        return idPercurso;
    }

    public void setIdPercurso(TbPercurso idPercurso) {
        this.idPercurso = idPercurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrisma != null ? idPrisma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPrisma)) {
            return false;
        }
        TbPrisma other = (TbPrisma) object;
        if ((this.idPrisma == null && other.idPrisma != null) || (this.idPrisma != null && !this.idPrisma.equals(other.idPrisma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbPrisma[ idPrisma=" + idPrisma + " ]";
    }
    
}
