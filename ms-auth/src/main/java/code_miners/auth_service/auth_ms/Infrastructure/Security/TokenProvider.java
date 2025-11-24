package code_miners.auth_service.auth_ms.Infrastructure.Security;

import code_miners.auth_service.auth_ms.Core.Application.Contracts.Security.ITokenProvider;
import code_miners.auth_service.auth_ms.Core.Domain.Entity.Usuario;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class TokenProvider implements ITokenProvider {
    private final JwtEncoder jwtEncoder;

    public TokenProvider(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @Override
    public String generateJwtToken(Usuario usuario) {
        Instant now = Instant.now();
        List<String> roles = usuario
                .getTipos().stream()
                .map(tipo -> tipo.getRole().name())
                .toList();

        JwtClaimsSet claims  = JwtClaimsSet.builder()
                .subject(usuario.getId().toString())
                .issuedAt(now)
                .expiresAt(now.plus(15, ChronoUnit.MINUTES))
                .claim("email", usuario.getEmail())
                .claim("roles", roles)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims))
                .getTokenValue();
    }
}
