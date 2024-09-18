package kz.practice.exception.task_1;

public class Test {
    public static void main(String[] args) throws PasswordValidateException {

        try {
            validatePassword("Admin12");
        } catch (PasswordValidateException e) {
            System.out.println(e.getMessage());
        }

        try {
            validatePassword("admiuduudjcbnncd123");
        } catch (PasswordValidateException e) {
            System.out.println(e.getMessage());
        }

    }

    static void validatePassword(String password) throws PasswordValidateException {
        boolean passwordDigit = false;
        boolean passwordUpperCase = false;

        if (password.length() < 8) {
            throw new PasswordValidateException("Password less than 8 symbols");
        }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                passwordDigit = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                passwordUpperCase = true;
            }
        }

        if (!passwordDigit) {
            throw new PasswordValidateException("Пароль должен содержать мин 1 цифру");
        }

        if (!passwordUpperCase) {
            throw new PasswordValidateException("Должна быть мин 1 заглавная буква");
        }
    }
}
