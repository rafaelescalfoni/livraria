package br.ucb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
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

/**
 *
 * @author rafaelescalfoni
 */
@Entity
@Table(name = "livro")
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findById", query = "SELECT l FROM Livro l WHERE l.id = :id"),
    @NamedQuery(name = "Livro.findByIsbn", query = "SELECT l FROM Livro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Livro.findByResumo", query = "SELECT l FROM Livro l WHERE l.resumo = :resumo"),
    @NamedQuery(name = "Livro.findByAutor", query = "SELECT l FROM Livro l WHERE l.autor = :autor"),
    @NamedQuery(name = "Livro.findByPreco", query = "SELECT l FROM Livro l WHERE l.preco = :preco")})
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "resumo")
    private String resumo;
    @Column(name = "autor")
    private String autor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private BigDecimal preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livro")
    private List<Compra> compraList;
    @JoinColumn(name = "editora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Editora editora;
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Genero genero;

    public Livro() {
    }

    public Livro(Long id) {
        this.id = id;
    }

    public Livro(Long id, String isbn, String titulo, BigDecimal preco) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ucb.model.Livro[ id=" + id + " ]";
    }
    
}
