/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.checko.services;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Roberto Duré
 */
@Embeddable
public class TbUsuariosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @Column(name = "USER_CODIGO")
    private int userCodigo;

    public TbUsuariosPK() {
    }

    public TbUsuariosPK(int userId, int userCodigo) {
        this.userId = userId;
        this.userCodigo = userCodigo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserCodigo() {
        return userCodigo;
    }

    public void setUserCodigo(int userCodigo) {
        this.userCodigo = userCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) userCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuariosPK)) {
            return false;
        }
        TbUsuariosPK other = (TbUsuariosPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.userCodigo != other.userCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.checko.services.TbUsuariosPK[ userId=" + userId + ", userCodigo=" + userCodigo + " ]";
    }
    
}
