package code_miners.auth_service.auth_ms.Infrastructure;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Collection;
import java.util.stream.Collectors;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${spring.jwt.public.key}")
    private RSAPublicKey publicKey;
    @Value("${spring.jwt.private.key}")
    private RSAPrivateKey privateKey;

    @Bean 
    public SecurityFilterChain securityWebFilterChain(HttpSecurity http) {
       return http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(auth -> auth
                       .requestMatchers("/api/v1/register-user").permitAll()
                       .requestMatchers("/api/v1/login").permitAll()
                       .requestMatchers("/api/v1/add-user-role").hasRole("ADMIN")
                       .requestMatchers("/api/v1/test-admin-role").hasRole("ADMIN")
                       .requestMatchers("/api/v1/test-professor-role").hasRole("PROFESSOR")
                       .requestMatchers(
                               "/swagger-ui.html",
                               "/swagger-ui/**",
                               "/v3/api-docs/**",
                               "/v3/api-docs.yaml"
                       ).permitAll()
                       .anyRequest().authenticated()
               )
               .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        var baseConverter = new JwtGrantedAuthoritiesConverter();
        baseConverter.setAuthoritiesClaimName("roles");
        baseConverter.setAuthorityPrefix("ROLE_");

        var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Collection<GrantedAuthority> authorities = baseConverter.convert(jwt);
            return authorities.stream()
                    .map(ga -> new SimpleGrantedAuthority(ga.getAuthority().toUpperCase()))
                    .collect(Collectors.toList());
        });

        return jwtAuthenticationConverter;
    }

    @Bean
    public JwtEncoder jwtEncoder(){
        JWK jwk = new RSAKey.Builder(this.publicKey).privateKey(this.privateKey).build();
        var jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

    @Bean
    public JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withPublicKey(this.publicKey).build();
    }
}
