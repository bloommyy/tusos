package bg.dimps.tusos.controllers;

import bg.dimps.tusos.pojos.request.ResetPasswordRequest;
import bg.dimps.tusos.security.jwt.JwtUtils;
import bg.dimps.tusos.security.pojos.request.LoginRequest;
import bg.dimps.tusos.security.pojos.response.JwtResponse;
import bg.dimps.tusos.security.services.UserDetailsImpl;
import bg.dimps.tusos.services.IdentityService;
import bg.dimps.tusos.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping()
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    private final IdentityService identityService;

    public UserController(
            AuthenticationManager authenticationManager,
            JwtUtils jwtUtils,
            IdentityService identityService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.identityService = identityService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("resetPassoword")
    public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest){
        return identityService.resetPassword(resetPasswordRequest.getEmail());
    }
}
