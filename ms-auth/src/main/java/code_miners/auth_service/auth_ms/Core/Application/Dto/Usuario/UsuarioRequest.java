package code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank String nome,
        @Email String email,
        @NotBlank String senha) {
}
