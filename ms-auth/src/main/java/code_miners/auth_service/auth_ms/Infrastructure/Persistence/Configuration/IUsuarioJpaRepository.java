package code_miners.auth_service.auth_ms.Infrastructure.Persistence.Configuration;

import code_miners.auth_service.auth_ms.Core.Domain.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioJpaRepository extends JpaRepository<Usuario,Long> {
    Usuario getByEmail(String email);
}
