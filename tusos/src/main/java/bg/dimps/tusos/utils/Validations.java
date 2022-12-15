package bg.dimps.tusos.utils;

import bg.dimps.tusos.entities.User;

public class Validations {
    private User user;

    public boolean validateEmail(String email) {
        return email.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }

    public boolean validatePassword(String password) {
        return password.length() >= 8;
    }

    public boolean validateRepeatedPassword(String repeatedPassword) {
        return repeatedPassword.equals(user.getPassword());
    }

    public boolean validateName(String name) {
        return name.length() > 1 && name.matches("[A-Z]\\w*") && name.matches("[a-z]");
    }

    public boolean validateFacultyNumber(String facultyNumber) {
        return facultyNumber.length() == 9 && facultyNumber.matches("[0-9]");
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\+(?:[0-9] ?){6,14}[0-9]$");
    }

}