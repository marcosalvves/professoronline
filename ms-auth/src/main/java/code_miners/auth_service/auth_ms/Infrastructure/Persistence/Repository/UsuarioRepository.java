package code_miners.auth_service.auth_ms.Infrastructure.Persistence.Repository;

import code_miners.auth_service.auth_ms.Core.Application.Contracts.Persistence.IUsuarioRepository;
import code_miners.auth_service.auth_ms.Core.Domain.Entity.Usuario;
import code_miners.auth_service.auth_ms.Infrastructure.Persistence.Configuration.IUsuarioJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository implements IUsuarioRepository {
    private final IUsuarioJpaRepository repository;

    public UsuarioRepository(IUsuarioJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario getUserByEmail(String email) {
        return repository.getByEmail(email);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return repository.save(usuario);
    }
}
