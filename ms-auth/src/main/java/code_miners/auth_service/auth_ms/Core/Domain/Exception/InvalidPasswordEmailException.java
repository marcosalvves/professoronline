package code_miners.auth_service.auth_ms.Core.Domain.Exception;

public class InvalidPasswordEmailException extends RuntimeException {
    public InvalidPasswordEmailException()
    {
        super("Invalid email or password");
    }
}
