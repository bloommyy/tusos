package bg.dimps.tusos.services;

import org.springframework.http.ResponseEntity;

public interface IdentityService {
    public ResponseEntity<String> resetPassword(String receiverEmail);
}
