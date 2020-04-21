package livraria.livraria.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cliente extends Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;
    private String cpf;
    @OneToOne //Essa é a forma mais usada de OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Venda> compras;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Venda> getCompras() {
        return compras;
    }

    public void setCompras(List<Venda> compras) {
        this.compras = compras;
    }
}
