package livraria.livraria.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Cliente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL) //Essa é a forma mais usada de OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private List<Venda> compras;

//    @Transient
//    private Collection<GrantedAuthority> permissoes = new ArrayList<>();

    public Cliente(){
    };

//    public Cliente(List<GrantedAuthority> authorityListUser){
//        this.permissoes = authorityListUser;
//    }
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

//    public Collection<GrantedAuthority> getPermissoes() {
//        return permissoes;
//    }
//
//    public void setPermissoes(Collection<GrantedAuthority> permissoes) {
//        this.permissoes = permissoes;
//    }

    @Override
    public String toString() {
        return  "Cliente{" + "id='"+super.getId() +'\'' +
                ", nome='"+super.getNome()+ '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco +
                ", compras=" + compras +
                '}';
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return permissoes;
//    }


}
