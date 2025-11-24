package code_miners.auth_service.auth_ms.Core.Application.Mapper;

import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioRequest;
import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioResponse;
import code_miners.auth_service.auth_ms.Core.Domain.Entity.Usuario;

public interface IUsuarioMapper extends IMapper<UsuarioResponse, UsuarioRequest, Usuario> {
}
