package code_miners.auth_service.auth_ms.Core.Application.Dto.Auth;

import code_miners.auth_service.auth_ms.Core.Application.Contracts.Service.IAuthService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@Email String email,@NotBlank String password){
}
