package code_miners.auth_service.auth_ms.Core.Application.Service;

import code_miners.auth_service.auth_ms.Core.Application.Contracts.Persistence.IUsuarioRepository;
import code_miners.auth_service.auth_ms.Core.Application.Contracts.Security.ITokenProvider;
import code_miners.auth_service.auth_ms.Core.Application.Contracts.Service.IAuthService;
import code_miners.auth_service.auth_ms.Core.Application.Contracts.Security.IPasswordEncoder;
import code_miners.auth_service.auth_ms.Core.Application.Dto.Auth.LoginRequest;
import code_miners.auth_service.auth_ms.Core.Domain.Exception.InvalidPasswordEmailException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    private final IUsuarioRepository usuarioRepository;
    private final IPasswordEncoder passwordEncoder;
    private final ITokenProvider tokenProvider;

    public AuthService(IUsuarioRepository usuarioRepository, IPasswordEncoder passwordEncoder, ITokenProvider tokenProvider) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public String login(LoginRequest request) {
        var entity = usuarioRepository.getUserByEmail(request.email());
        if(!passwordEncoder.checkPassword(request.password(),
                entity.getSenha(), entity.getSalt())){
            throw new InvalidPasswordEmailException();
        };

        return tokenProvider.generateJwtToken(entity);


    }


}
