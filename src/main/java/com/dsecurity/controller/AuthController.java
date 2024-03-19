package com.dsecurity.controller;

import com.dsecurity.entity.Users;
import com.dsecurity.repository.UserRepository;
import com.dsecurity.security.jwt.JwtProvider;
import com.dsecurity.security.response.JwtResponse;
import com.dsecurity.security.response.ResponseMessage;
import com.dsecurity.security.userPrincipal.UserPrincipal;
import com.dsecurity.service.UserService;
import com.dsecurity.service.dto.SignInForm;
import com.dsecurity.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/signUp")
    public ResponseEntity<ResponseMessage> signUp(@RequestBody UserDTO userDTO) {
        try {
            if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
                return ResponseEntity.badRequest()
                        .body(ResponseMessage.builder()
                                .status("Failed")
                                .message("Username is already taken!")
                                .build());
            }
            Users registeredUserDTO = userService.registerUser(userDTO, userDTO.getPassword());

            return ResponseEntity.ok()
                    .body(ResponseMessage.builder()
                            .status("Success")
                            .message("User registered successfully!")
                            .data(registeredUserDTO)
                            .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseMessage.builder()
                            .status("Failed")
                            .message("An error occurred while registering user!")
                            .build());
        }
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody SignInForm signInForm) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signInForm.getUsername(),
                            signInForm.getPassword())
            );

            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            String token = jwtProvider.generateToken(authentication);
            return ResponseEntity.ok(
                    JwtResponse.builder()
                            .status("OK")
                            .type("Bearer")
                            .fullName(userPrincipal.getFullName())
                            .token(token)
                            .roles(userPrincipal.getAuthorities())
                            .build());

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ResponseMessage.builder()
                            .status("Failed")
                            .message("Invalid username or password!")
                            .build());
        }
    }
}
