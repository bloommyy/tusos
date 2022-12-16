package bg.dimps.tusos.controllers;

import bg.dimps.tusos.security.pojos.request.HostSignupRequest;
import bg.dimps.tusos.services.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/host")
@CrossOrigin(origins = "*")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerHost(@RequestBody HostSignupRequest hostSignupRequest) {
        try {
            hostService.validateRequest(hostSignupRequest);
            hostService.checkExistenceByEmail(hostSignupRequest.getEmail());
            hostService.saveHost(hostSignupRequest);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok("User registered successfully!");
    }
}
