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
@Table(name = "tb_grupos_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbGruposUsuarios.findAll", query = "SELECT t FROM TbGruposUsuarios t"),
    @NamedQuery(name = "TbGruposUsuarios.findByGrupoId", query = "SELECT t FROM TbGruposUsuarios t WHERE t.grupoId = :grupoId"),
    @NamedQuery(name = "TbGruposUsuarios.findByDescricao", query = "SELECT t FROM TbGruposUsuarios t WHERE t.descricao = :descricao")})
public class TbGruposUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GRUPO_ID")
    private Integer grupoId;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private Collection<TbUsuarios> tbUsuariosCollection;

    public TbGruposUsuarios() {
    }

    public TbGruposUsuarios(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public TbGruposUsuarios(Integer grupoId, String descricao) {
        this.grupoId = grupoId;
        this.descricao = descricao;
    }

    public Integer getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<TbUsuarios> getTbUsuariosCollection() {
        return tbUsuariosCollection;
    }

    public void setTbUsuariosCollection(Collection<TbUsuarios> tbUsuariosCollection) {
        this.tbUsuariosCollection = tbUsuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoId != null ? grupoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbGruposUsuarios)) {
            return false;
        }
        TbGruposUsuarios other = (TbGruposUsuarios) object;
        if ((this.grupoId == null && other.grupoId != null) || (this.grupoId != null && !this.grupoId.equals(other.grupoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbGruposUsuarios[ grupoId=" + grupoId + " ]";
    }
    
}
