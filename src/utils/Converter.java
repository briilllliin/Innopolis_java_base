package utils;

import module.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public List<User> convertStringToUser(String userInfoString) {
        String[] userLines = userInfoString.split("\n");
        List<User> users = new ArrayList<>();

        for (String userLine : userLines) {
            String[] userInfoArray = userLine.split("\\|");
            validateUserInfoArray(userInfoArray);

            User user = createUserFromInfoArray(userInfoArray);
            users.add(user);
        }

        return users;
    }

    private void validateUserInfoArray(String[] userInfoArray) {
        if (userInfoArray.length != 10) {
            throw new IllegalArgumentException("Некорректный формат строки для конвертации в User");
        }
    }

    private User createUserFromInfoArray(String[] userInfoArray) {
        User user = new User();
        user.setId(userInfoArray[0]);
        user.setRegistrationDate(LocalDateTime.parse(userInfoArray[1]));
        user.setLogin(userInfoArray[2]);
        user.setPassword(userInfoArray[3]);
        user.setConfirmPassword(userInfoArray[4]);
        user.setLastName(userInfoArray[5]);
        user.setFirstName(userInfoArray[6]);
        user.setMiddleName(userInfoArray[7]);
        user.setAge(Integer.parseInt(userInfoArray[8]));
        user.setWorker(Boolean.parseBoolean(userInfoArray[9]));

        return user;
    }
}
