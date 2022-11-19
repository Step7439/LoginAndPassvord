package com.example.loginandpassvord.authorizaControl;

import com.example.loginandpassvord.authoritiesModel.Authorities;
import com.example.loginandpassvord.authorizaService.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController (AuthorizationService service) {
        this.service = service;
    }


    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam ("user") @Validated String user, @RequestParam ("password") @Validated String password) {
        return service.getAuthorities(user, password);
    }
}