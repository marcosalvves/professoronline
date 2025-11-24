package code_miners.auth_service.auth_ms.Core.Application.Contracts.Security;

import code_miners.auth_service.auth_ms.Core.Domain.Entity.Usuario;

public interface ITokenProvider {
    String generateJwtToken(Usuario usuario);

}
