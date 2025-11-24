package code_miners.auth_service.auth_ms.Core.Application.Contracts.Service;

import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioRequest;
import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioResponse;

public interface IUsuarioService {
    UsuarioResponse register(UsuarioRequest request);
}
