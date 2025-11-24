package code_miners.auth_service.auth_ms.Infrastructure.Security;

import code_miners.auth_service.auth_ms.Core.Application.Contracts.Security.IPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthPasswordEncoder implements IPasswordEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public String encode(String rawPassword, String salt) {
        rawPassword+=salt;
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean checkPassword(String plainPassword, String encodedPassword, String salt) {
        plainPassword+=salt;
        return bCryptPasswordEncoder.matches(plainPassword, encodedPassword);
    }
}
