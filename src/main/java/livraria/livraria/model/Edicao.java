package livraria.livraria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Edicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ano;
    private int numero;
    private BigDecimal valor;
    private int estoque;
    private int numPaginas;
    private String isbn;
    private boolean disponivel = true;
    private int quantidade=1;

    @ElementCollection
    @CollectionTable(name = "edicao_imagens", joinColumns = @JoinColumn(name = "livro_id"))
    @Column(name = "imagens")
    private List<String> imagens;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn(name = "livro_id") // porque é nessa tabela que vai ter a chave estrangeira que referencia Livro
    private Livro livro;

    @ManyToOne(cascade = CascadeType.ALL) //Uma editora pode publicar muitas edições
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany(mappedBy = "edicoes")
    private List<Venda> vendas;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Edicao{" +
                "id=" + id +
                ", ano='" + ano + '\'' +
                ", numero=" + numero +
                ", valor=" + valor +
                ", estoque=" + estoque +
                ", numPaginas=" + numPaginas +
                ", isbn='" + isbn + '\'' +
                ", disponivel=" + disponivel +
                ", imagens=" + imagens +
                ", livro=" + livro +
                ", editora=" + editora +
                ", vendas=" + vendas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edicao)) return false;
        Edicao edicao = (Edicao) o;
        return Objects.equals(getId(), edicao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
