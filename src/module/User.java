package module;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {

    private String id = generateUniqueID();
    private LocalDateTime registrationDate = LocalDateTime.now();
    private String login;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private boolean isWorker = true;

    public User() {
        password = generatePassword();
        confirmPassword = password;

    }

    public User(String login, String password, String confirmPassword, String lastName, String firstName, String middleName, Integer age, boolean isWorker) {
        setLogin(login);
        setPassword(password, confirmPassword);
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.isWorker = isWorker;
    }

    public User(String id, String login, String password, String confirmPassword, String lastName, String firstName, String middleName, Integer age, boolean isWorker) {
        this.id = id;
        setLogin(login);
        setPassword(password, confirmPassword);
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.isWorker = isWorker;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.length() >= 20) {
            throw new IllegalArgumentException("Логин не может быть длиннее 20 символов");
        }
        if (!login.matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalArgumentException("Логин может содержать только буквы, цифры и знак подчеркивания");
        }
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пароль не может быть null");
        }
        if (password.length() > 20) {
            throw new IllegalArgumentException("Пароль должен содержать менее 20 символов");
        }
        if (!password.matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalArgumentException("Пароль может содержать только буквы, цифры и знак подчеркивания");
        }
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        if (confirmPassword == null) {
            throw new IllegalArgumentException("Подтверждение пароля не может быть null");
        }
        if (confirmPassword.length() > 20) {
            throw new IllegalArgumentException("Подтверждение пароля должно содержать менее 20 символов");
        }
        if (!confirmPassword.matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalArgumentException("Подтверждение пароля может содержать только буквы, цифры и знак подчеркивания");
        }
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("Пароль и подтверждение пароля не совпадают");
        }
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean isWorker) {
        this.isWorker = isWorker;
    }


    private String generateUniqueID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String generatePassword() {
        String password = UUID.randomUUID().toString().replaceAll("-", "");
        return password.substring(0, Math.min(password.length(), 15));
    }

    public void delete() {
        this.registrationDate = null;
        this.login = null;
        this.password = null;
        this.confirmPassword = null;
        this.lastName = null;
        this.firstName = null;
        this.middleName = null;
        this.isWorker = false;
    }

    @Override
    public String toString() {
        return id + "|" + registrationDate + "|" +
                login + "|" +
                password + "|" +
                confirmPassword + "|" +
                lastName + "|" +
                firstName + "|" +
                middleName + "|" +
                age + "|" +
                isWorker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && isWorker == user.isWorker && Objects.equals(id, user.id) && Objects.equals(registrationDate, user.registrationDate) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(middleName, user.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationDate, login, password, confirmPassword, firstName, lastName, middleName, age, isWorker);
    }
}
