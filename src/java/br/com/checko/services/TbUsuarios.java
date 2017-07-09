/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checko.services;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tb_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuarios.findAll", query = "SELECT t FROM TbUsuarios t"),
    @NamedQuery(name = "TbUsuarios.findByUserId", query = "SELECT t FROM TbUsuarios t WHERE t.tbUsuariosPK.userId = :userId"),
    @NamedQuery(name = "TbUsuarios.findByUserCodigo", query = "SELECT t FROM TbUsuarios t WHERE t.tbUsuariosPK.userCodigo = :userCodigo"),
    @NamedQuery(name = "TbUsuarios.findByEpgNome", query = "SELECT t FROM TbUsuarios t WHERE t.epgNome = :epgNome"),
    @NamedQuery(name = "TbUsuarios.findByUlogin", query = "SELECT t FROM TbUsuarios t WHERE t.ulogin = :ulogin"),
    @NamedQuery(name = "TbUsuarios.findBySenha", query = "SELECT t FROM TbUsuarios t WHERE t.senha = :senha")})
public class TbUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbUsuariosPK tbUsuariosPK;
    @Basic(optional = false)
    @Column(name = "EPG_NOME")
    private String epgNome;
    @Basic(optional = false)
    @Column(name = "ULOGIN")
    private String ulogin;
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "GRUPO_ID")
    @ManyToOne(optional = false)
    private TbGruposUsuarios idGrupo;

    public TbUsuarios() {
    }

    public TbUsuarios(TbUsuariosPK tbUsuariosPK) {
        this.tbUsuariosPK = tbUsuariosPK;
    }

    public TbUsuarios(TbUsuariosPK tbUsuariosPK, String epgNome, String ulogin, String senha) {
        this.tbUsuariosPK = tbUsuariosPK;
        this.epgNome = epgNome;
        this.ulogin = ulogin;
        this.senha = senha;
    }

    public TbUsuarios(int userId, int userCodigo) {
        this.tbUsuariosPK = new TbUsuariosPK(userId, userCodigo);
    }

    public TbUsuariosPK getTbUsuariosPK() {
        return tbUsuariosPK;
    }

    public void setTbUsuariosPK(TbUsuariosPK tbUsuariosPK) {
        this.tbUsuariosPK = tbUsuariosPK;
    }

    public String getEpgNome() {
        return epgNome;
    }

    public void setEpgNome(String epgNome) {
        this.epgNome = epgNome;
    }

    public String getUlogin() {
        return ulogin;
    }

    public void setUlogin(String ulogin) {
        this.ulogin = ulogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TbGruposUsuarios getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(TbGruposUsuarios idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbUsuariosPK != null ? tbUsuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuarios)) {
            return false;
        }
        TbUsuarios other = (TbUsuarios) object;
        if ((this.tbUsuariosPK == null && other.tbUsuariosPK != null) || (this.tbUsuariosPK != null && !this.tbUsuariosPK.equals(other.tbUsuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbUsuarios[ tbUsuariosPK=" + tbUsuariosPK + " ]";
    }
    
}
