package code_miners.auth_service.auth_ms.Core.Application.Mapper;

import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioRequest;
import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioResponse;
import code_miners.auth_service.auth_ms.Core.Domain.Entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements IUsuarioMapper {
    @Override
    public UsuarioResponse toDto(Usuario usuario) {
        return new UsuarioResponse(usuario.getNome(), usuario.getEmail());
    }

    @Override
    public Usuario toEntity(UsuarioRequest request) {
        return new Usuario(request.nome(),
                request.email(),
                request.senha(),
                true);
    }
}
