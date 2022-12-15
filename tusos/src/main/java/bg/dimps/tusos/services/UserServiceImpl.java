package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.ERole;
import bg.dimps.tusos.entities.Role;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.RoleRepository;
import bg.dimps.tusos.security.pojos.request.UserSignupRequest;

import java.util.HashSet;
import java.util.Set;

public class UserServiceImpl implements UserService{
    RoleRepository roleRepository;

    public UserServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public String checkRequest(UserSignupRequest studentSignupRequest) {
        return null;
    }

    @Override
    public void setRoles(User user, Set<String> strRoles) {
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
