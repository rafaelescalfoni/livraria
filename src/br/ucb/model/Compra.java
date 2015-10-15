package br.ucb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rafaelescalfoni
 */
@Entity
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "Compra.findByUsuarioId", query = "SELECT c FROM Compra c WHERE c.compraPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "Compra.findByLivroId", query = "SELECT c FROM Compra c WHERE c.compraPK.livroId = :livroId"),
    @NamedQuery(name = "Compra.findByQuantidade", query = "SELECT c FROM Compra c WHERE c.quantidade = :quantidade"),
    @NamedQuery(name = "Compra.findByDataVenda", query = "SELECT c FROM Compra c WHERE c.dataVenda = :dataVenda")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompraPK compraPK;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "data_venda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "livro_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Livro livro;

    public Compra() {
    }

    public Compra(CompraPK compraPK) {
        this.compraPK = compraPK;
    }

    public Compra(CompraPK compraPK, int quantidade, Date dataVenda) {
        this.compraPK = compraPK;
        this.quantidade = quantidade;
        this.dataVenda = dataVenda;
    }

    public Compra(long usuarioId, long livroId) {
        this.compraPK = new CompraPK(usuarioId, livroId);
    }

    public CompraPK getCompraPK() {
        return compraPK;
    }

    public void setCompraPK(CompraPK compraPK) {
        this.compraPK = compraPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraPK != null ? compraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraPK == null && other.compraPK != null) || (this.compraPK != null && !this.compraPK.equals(other.compraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.model.Compra[ compraPK=" + compraPK + " ]";
    }
    
}
