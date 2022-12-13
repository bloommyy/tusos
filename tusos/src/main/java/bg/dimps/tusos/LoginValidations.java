package bg.dimps.tusos;

import bg.dimps.tusos.entities.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidations {
    Student student;
    private boolean validateEmail(String email)
    {
        return email.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }
    private boolean validatePassword(String password)
    {
        return password.length()>=8;
    }
    private boolean validateRepeatedPassword(String repeatedPassword)
    {
        return repeatedPassword.equals(student.getPassword());
    }
    private boolean validateFirstName(String firstName)
    {
       return firstName.length() > 1 && firstName.matches("[A-Z]\\w*") && firstName.matches("[a-z]");

    }
    private boolean validateMiddleName(String middleName)
    {
        return middleName.length() > 1 && middleName.matches("[A-Z]\\w*") && middleName.matches("[a-z]");
    }
    private boolean validateLastName(String lastName)
    {
        return lastName.length() > 1 && lastName.matches("[A-Z]\\w*") && lastName.matches("[a-z]");
    }
    private boolean validateFacultyNumber(String facultyNumber)
    {
        return facultyNumber.length() == 9 && facultyNumber.matches("[0-9]");
    }
    private boolean validatePhoneNumber(String phoneNumber)
    {
        return phoneNumber.matches("^\\+(?:[0-9] ?){6,14}[0-9]$");
   }

}