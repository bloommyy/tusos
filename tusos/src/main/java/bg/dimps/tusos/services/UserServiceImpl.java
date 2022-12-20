package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.ERole;
import bg.dimps.tusos.entities.Role;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.RoleRepository;
import bg.dimps.tusos.security.pojos.request.UserSignupRequest;
import bg.dimps.tusos.utils.Validations;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
public class UserServiceImpl implements UserService{

    RoleRepository roleRepository;

    public UserServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void checkExistenceByEmail(String email) {
        return;
    }

    @Override
    public void validateRequest(UserSignupRequest userSignupRequest) throws RuntimeException {
        if(!Validations.validateEmail(userSignupRequest.getEmail()))
            throw new RuntimeException("Invalid email.");
        if(!Validations.validatePassword(userSignupRequest.getPassword()))
            throw new RuntimeException("Invalid password name.");
        if(!Validations.validateName(userSignupRequest.getFirstName()))
            throw new RuntimeException("Invalid first name.");
        if(!Validations.validateName(userSignupRequest.getMiddleName()))
            throw new RuntimeException("Invalid middle name.");
        if(!Validations.validateName(userSignupRequest.getLastName()))
            throw new RuntimeException("Invalid last name.");
        if(!Validations.validatePhoneNumber(userSignupRequest.getPhoneNumber()))
            throw new RuntimeException("Invalid phone number.");
        if(!Validations.validateRepeatedPassword(userSignupRequest.getPassword(), userSignupRequest.getRepeatedPassword()))
            throw new RuntimeException("Invalid repeated password.");
    }

    @Override
    public void setRoles(User user, Set<String> strRoles) throws RuntimeException{
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("ROLE_HOST".equals(role)) {
                    Role adminRole = roleRepository.findByName(ERole.ROLE_HOST)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
    }
}
