package bg.dimps.tusos.controllers;

import bg.dimps.tusos.security.pojos.request.HostSignupRequest;
import bg.dimps.tusos.services.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<?> registerHost(@RequestBody HostSignupRequest hostSignupRequest)
    {
        String checkRequest = hostService.checkRequest(hostSignupRequest);
        if (checkRequest != "ok") {
            return ResponseEntity.badRequest().body("User already exists");
        } else {
            hostService.saveHost(hostSignupRequest);
        }
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('ROLE_HOST')")
    public ResponseEntity<?> test()
    {
        return ResponseEntity.ok("eto we 6efe");
    }
}
