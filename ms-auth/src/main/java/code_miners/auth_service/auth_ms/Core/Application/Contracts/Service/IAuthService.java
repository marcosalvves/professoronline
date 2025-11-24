package code_miners.auth_service.auth_ms.Core.Application.Contracts.Service;

import code_miners.auth_service.auth_ms.Core.Application.Dto.Auth.LoginRequest;

public interface IAuthService {
    String login(LoginRequest request);
}
