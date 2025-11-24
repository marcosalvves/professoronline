package code_miners.auth_service.auth_ms.Core.Application.Service;

import code_miners.auth_service.auth_ms.Core.Application.Contracts.Persistence.IUsuarioRepository;
import code_miners.auth_service.auth_ms.Core.Application.Contracts.Security.IPasswordEncoder;
import code_miners.auth_service.auth_ms.Core.Application.Contracts.Service.IUsuarioService;
import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioRequest;
import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioResponse;
import code_miners.auth_service.auth_ms.Core.Application.Mapper.IUsuarioMapper;
import code_miners.auth_service.auth_ms.Core.Domain.Entity.Usuario;
import code_miners.auth_service.auth_ms.Core.Domain.Exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UsuarioService implements IUsuarioService {
    private final IUsuarioRepository repository;
    private final IUsuarioMapper mapper;
    private final IPasswordEncoder encoder;

    public UsuarioService(IUsuarioRepository repository, IUsuarioMapper mapper, IPasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public UsuarioResponse register(UsuarioRequest request) {
        if(repository.getUserByEmail(request.email()) != null){
            throw new UserAlreadyExistsException(request.email());
        }

        var entity = hashPassword(request);
        entity = repository.save(entity);
        return mapper.toDto(entity);
    }

    private String generateSalt(){
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private Usuario hashPassword(UsuarioRequest request){
        var entity = mapper.toEntity(request);
        entity.setSalt(this.generateSalt());
        entity.setPassword(encoder.encode(entity.getSenha(), entity.getSalt()));
        return entity;
    }
}
