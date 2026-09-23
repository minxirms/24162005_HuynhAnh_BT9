package vn.minxi.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.minxi.dto.*;
import vn.minxi.service.AuthService;

@Controller
public class AuthController {
	private final AuthService auth;

	public AuthController(AuthService auth) {
		this.auth = auth;
	}

	@GetMapping("/login")
    public String login() {
        return "auth/login"; // Hoặc "login" tùy theo cách bạn chọn ở trên
    }
}
