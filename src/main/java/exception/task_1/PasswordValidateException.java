package exception.task_1;

public class PasswordValidateException extends Throwable {
    public PasswordValidateException(String message) {
        super(message);
    }
}