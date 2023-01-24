package bg.dimps.tusos.utils;

public abstract class Validations {
    public static boolean validateEmail(String email) {
        return email.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }

    public static boolean validatePassword(String password) {
        return password.length() >= 8;
    }

    public static boolean validateRepeatedPassword(String password, String repeatedPassword) {
        return true;
    }

    public static boolean validateName(String name) {
        return true;
    }

    public static boolean validateFacultyNumber(String facultyNumber) {
        return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return true;
    }

}