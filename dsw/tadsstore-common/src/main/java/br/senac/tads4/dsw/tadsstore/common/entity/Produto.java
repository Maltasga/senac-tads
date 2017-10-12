package br.senac.tads4.dsw.tadsstore.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 *
 * @author gabriel.malta
 */
@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO", length = 100, nullable = false)
    @Size(min = 1, max = 100, message = "{produto.nome.erro}")
    private String nome;

    @Column(name = "DS_PRODUTO", length = 1000, nullable = false)
    @Size(min = 1, max = 1000, message = "{produto.descricao.erro}")
    private String descricao;

    @Column(name = "VL_PRODUTO", nullable = false, precision = 6, scale = 2)
    @Digits(integer = 6, fraction = 2, message = "{produto.preco.erro}")
    private BigDecimal preco;

    @Column(name = "DT_CADASTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCadastro;

    @ManyToMany
    @JoinTable(name = "TB_PRODUTO_CATEGORIA",
            joinColumns = {
                @JoinColumn(name = "ID_PRODUTO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_CATEGORIA")})
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ImagemProduto> imagens;

    @Transient
    private String observacoes;

    public Produto() {

    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, Date dtCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dtCadastro = dtCadastro;
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, Date dtCadastro, List<ImagemProduto> imagens, List<Categoria> categorias) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.dtCadastro = dtCadastro;
        this.imagens = imagens;
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<ImagemProduto> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemProduto> imagens) {
        this.imagens = imagens;
    }
//
//  public List<ItemCompra> getItensCompra() {
//    return itensCompra;
//  }
//
//  public void setItensCompra(List<ItemCompra> itensCompra) {
//    this.itensCompra = itensCompra;
//  }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", dtCadastro=" + dtCadastro + ", categorias=" + categorias + ", imagens=" + imagens + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
