package code_miners.auth_service.auth_ms.Presentation.Controller;

import code_miners.auth_service.auth_ms.Core.Application.Contracts.Service.IUsuarioService;
import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioRequest;
import code_miners.auth_service.auth_ms.Core.Application.Dto.Usuario.UsuarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UsuarioController {
    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register-user")
    public ResponseEntity<UsuarioResponse> register(@RequestBody UsuarioRequest request)
    {
        try
        {
            var response = usuarioService.register(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add-user-role")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello");
    }
}
