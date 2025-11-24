package code_miners.auth_service.auth_ms.Core.Domain.Entity;

import code_miners.auth_service.auth_ms.Core.Domain.Common.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "tipo_usuario")
@Entity
@Getter
public class TipoUsuario extends BaseEntity{
    @Enumerated(EnumType.STRING)
    Role role;
}
