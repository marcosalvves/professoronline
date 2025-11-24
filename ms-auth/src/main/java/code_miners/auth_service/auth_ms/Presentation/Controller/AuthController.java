package code_miners.auth_service.auth_ms.Presentation.Controller;

import code_miners.auth_service.auth_ms.Core.Application.Dto.Auth.LoginRequest;
import code_miners.auth_service.auth_ms.Core.Application.Service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> Hello(@RequestBody LoginRequest request){
        try{
             var token = authService.login(request);
             return ResponseEntity.ok(token);
         }catch (Exception e){
             return ResponseEntity.badRequest().body(e.getMessage());
         }
    };

    @PostMapping("/test-professor-role")
    public ResponseEntity<String> testProfessorRole(){
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/test-admin-role")
    public ResponseEntity<String> testAdminRole(){
        return ResponseEntity.ok("Hello");
    }


}
