package bg.dimps.tusos.services;

import bg.dimps.tusos.entities.ERole;
import bg.dimps.tusos.entities.Role;
import bg.dimps.tusos.entities.User;
import bg.dimps.tusos.repositories.RoleRepository;
import bg.dimps.tusos.security.pojos.request.UserSignupRequest;
import bg.dimps.tusos.utils.Validations;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
public class UserServiceImpl implements UserService{
    RoleRepository roleRepository;
    Validations validations;
    public UserServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public String checkRequest(UserSignupRequest studentSignupRequest) {
        return null;
    }

    @Override
    public void validateStudent(String email, String password, String firstName, String middleName, String lastName, String phoneNumber, String facultyNumber, String repeatedPassword) {
        if(!validations.validateEmail(email))
            throw new RuntimeException("Invalid email");
        if(!validations.validatePassword(password))
            throw new RuntimeException("Invalid password name");
        if(!validations.validateName(firstName))
            throw new RuntimeException("Invalid first name");
        if(!validations.validateName(middleName))
            throw new RuntimeException("Invalid middle name");
        if(!validations.validateName(lastName))
            throw new RuntimeException("Invalid last name");
        if(!validations.validatePhoneNumber(phoneNumber))
            throw new RuntimeException("Invalid phone number");
        if(!validations.validateFacultyNumber(facultyNumber))
            throw new RuntimeException("Invalid faculty number");
        if(!validations.validateRepeatedPassword(repeatedPassword))
            throw new RuntimeException("Invalid repeated password");
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
