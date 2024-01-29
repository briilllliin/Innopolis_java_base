package exceptions;

public class UserNotFoundException extends IllegalArgumentException {
    static final String MESSAGE = "Пользователя с таким ID не существует";
    public UserNotFoundException() {
        super(MESSAGE);
    }
}
