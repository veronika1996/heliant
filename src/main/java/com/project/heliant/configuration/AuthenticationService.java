package com.project.heliant.configuration;

import com.project.heliant.dto.AuthenticationRequest;
import com.project.heliant.dto.AuthenticationResponse;
import com.project.heliant.dto.RegisterRequest;
import com.project.heliant.entity.KorisnikEntity;
import com.project.heliant.repository.KorisnikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final KorisnikRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationResponse register(RegisterRequest request) {
        KorisnikEntity korisnik = KorisnikEntity.builder()
                .korisnickoIme(request.getKorisnickoIme())
                .lozinka(passwordEncoder.encode(request.getLozinka()))
                .build();
        KorisnikEntity savedUser = repository.save(korisnik);
        String jwtToken = jwtService.generateToken(korisnik);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        KorisnikEntity user = repository.findByKorisnickoIme(request.getKorisnickoIme())
                .orElseThrow();
        String  jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
