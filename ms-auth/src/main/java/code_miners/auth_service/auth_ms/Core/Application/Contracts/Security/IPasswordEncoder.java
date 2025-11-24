package code_miners.auth_service.auth_ms.Core.Application.Contracts.Security;


public interface IPasswordEncoder {
    String encode(String rawPassword, String salt );
    boolean checkPassword(String plainPassword,
                          String encodedPassword, String salt);
}
