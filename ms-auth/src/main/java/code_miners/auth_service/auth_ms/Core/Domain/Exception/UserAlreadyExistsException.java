package code_miners.auth_service.auth_ms.Core.Domain.Exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {

        super("Email já está em uso: " + email);
    }
}
