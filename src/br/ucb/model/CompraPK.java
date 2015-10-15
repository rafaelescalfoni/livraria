package br.ucb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author rafaelescalfoni
 */
@Embeddable
public class CompraPK implements Serializable {
    @Column(name = "usuario_id")
    private long usuarioId;
    @Column(name = "livro_id")
    private long livroId;

    public CompraPK() {
    }

    public CompraPK(long usuarioId, long livroId) {
        this.usuarioId = usuarioId;
        this.livroId = livroId;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getLivroId() {
        return livroId;
    }

    public void setLivroId(long livroId) {
        this.livroId = livroId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioId;
        hash += (int) livroId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraPK)) {
            return false;
        }
        CompraPK other = (CompraPK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.livroId != other.livroId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.model.CompraPK[ usuarioId=" + usuarioId + ", livroId=" + livroId + " ]";
    }
    
}
