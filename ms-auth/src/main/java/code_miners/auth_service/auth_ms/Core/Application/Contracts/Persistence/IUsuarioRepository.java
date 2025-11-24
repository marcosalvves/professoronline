package code_miners.auth_service.auth_ms.Core.Application.Contracts.Persistence;

import code_miners.auth_service.auth_ms.Core.Domain.Entity.Usuario;

public interface IUsuarioRepository {
    public Usuario getUserByEmail(String email);
    public Usuario save(Usuario usuario);
    public Usuario update(Usuario usuario);
}
