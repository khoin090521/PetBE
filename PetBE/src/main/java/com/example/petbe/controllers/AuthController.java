package com.example.petbe.controllers;

import com.example.petbe.config.JWTConfig;
import com.example.petbe.dto.LoginRequestDTO;
import com.example.petbe.dto.LoginResponseDTO;
import com.example.petbe.dto.RegisterDto;
import com.example.petbe.models.User;
import com.example.petbe.repositories.UserRepository;
import com.example.petbe.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RequestMapping("api/auth")
@RestController
public class AuthController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @Autowired
    public AuthController( UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepository.existsByGmail(registerDto.getGmail())) {
            return new ResponseEntity<>("Gmail is taken!", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setGmail(registerDto.getGmail());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
        user.setPhone_number(registerDto.getPhone_number());
        user.setFull_name(registerDto.getFull_name());

        userRepository.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }


}
