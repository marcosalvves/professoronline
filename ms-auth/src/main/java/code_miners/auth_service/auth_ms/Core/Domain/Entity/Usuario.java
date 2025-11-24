package code_miners.auth_service.auth_ms.Core.Domain.Entity;

import code_miners.auth_service.auth_ms.Core.Domain.Common.Role;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Table(name = "usuario")
@Entity
@Getter
public class Usuario extends BaseEntity{
    private String nome;
    private String email;
    private String senha;
    private Boolean status;

    @OneToMany
    @JoinTable(
            name = "usuario_tipoUsuario",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "tipoUsuario_id")
    )
    private Set<TipoUsuario> tipos = new HashSet<TipoUsuario>();
    private String salt;

    public Usuario(){
    }

    public Usuario(String nome, String email, String senha, Boolean status ) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.status = status;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }

    public Usuario update(Usuario usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.status = usuario.getStatus();
        return this;
    }

    public void setPassword(String senha){
        this.senha = senha;
    }
}
