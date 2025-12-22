package com.bbt.blog.backend.api;

import com.bbt.blog.backend.api.responses.LoginResponse;
import com.bbt.blog.backend.business.abstracts.UserService;
import com.bbt.blog.backend.config.JwtUtil;
import com.bbt.blog.backend.entity.concretes.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (user.getId() != null && userService.getUserById(user.getId()) != null) {
            return new ResponseEntity<>("Bu ID zaten kullanımda!", HttpStatus.BAD_REQUEST);
        }

        User newUser = userService.saveUser(user);
        newUser.setPassword(null);
        String token = jwtUtil.generateToken(newUser.getUsername(), newUser.getRole());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LoginResponse(newUser, token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginDetails) {
        User user = userService.getByUsername(loginDetails.getUsername());

        if (user == null) {
            return new ResponseEntity<>("Kullanıcı adı veya şifre yanlış.", HttpStatus.UNAUTHORIZED);
        }

        if (!passwordEncoder.matches(loginDetails.getPassword(), user.getPassword())) {
            return new ResponseEntity<>("Kullanıcı adı veya şifre yanlış.", HttpStatus.UNAUTHORIZED);
        }

        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
        user.setPassword(null);

        return ResponseEntity.ok(new LoginResponse(user, token));
    }
}
