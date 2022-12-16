package bg.dimps.tusos.utils;

public abstract class Validations {
    public static boolean validateEmail(String email) {
        return email.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }

    public static boolean validatePassword(String password) {
        return password.length() >= 8;
    }

    public static boolean validateRepeatedPassword(String password, String repeatedPassword) {
        return repeatedPassword.equals(password);
    }

    public static boolean validateName(String name) {
        return name.length() > 1 && name.matches("[A-Z]\\w*") && name.matches("[a-z]");
    }

    public static boolean validateFacultyNumber(String facultyNumber) {
        return facultyNumber.length() == 9 && facultyNumber.matches("[0-9]");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\+(?:[0-9] ?){6,14}[0-9]$");
    }

}