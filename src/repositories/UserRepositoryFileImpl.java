package repositories;

import exceptions.UserNotFoundException;
import module.User;
import utils.Converter;
import utils.FileHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UserRepositoryFileImpl implements UserRepository {



    @Override
    public void create(User user) {
        FileHelper fileHelper = new FileHelper();
        fileHelper.writeToFile(user.toString(), true);
    }

    @Override
    public User findById(String id) {
        FileHelper fileHelper = new FileHelper();
        Converter converter = new Converter();
        try {
            List<User> usersCollection = converter.convertStringToUser(fileHelper.readFromFile());
            return usersCollection.stream().filter(user -> Objects.equals(id, user.getId())).findAny().orElse(null);
        } catch (IllegalArgumentException e) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> findAll() {
        FileHelper fileHelper = new FileHelper();
        Converter converter = new Converter();
        try {
            return converter.convertStringToUser(fileHelper.readFromFile());
        } catch (IllegalArgumentException e) {
            System.err.println("Неверный формат списка пользователей");
        }
        return new ArrayList<>();

    }

    @Override
    public User update(User user) {
        FileHelper fileHelper = new FileHelper();
        Converter converter = new Converter();

        List<User> userList = converter.convertStringToUser(fileHelper.readFromFile());
        try {
            User updateUser = userList.stream().filter(currentUser ->
                    Objects.equals(currentUser.getId(), user.getId())).findAny().orElse(null);

            if (updateUser == null) {
                System.out.println("Пользователя с таким ID не существует, создадим нового пользователя");
                userList.add(user);
                fileHelper.writeToFile(user.toString(), false);
            } else {
                List<User> updatedUsersList = userList.stream().map(currentUser -> Objects.equals(currentUser.getId(), user.getId()) ? user : currentUser).toList();

                for (User currentUser : updatedUsersList) {
                    fileHelper.writeToFile(currentUser.toString(), false);
                }

            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: ");
        }

        return user;
    }

    @Override
    public void deleteById(String id) {

        FileHelper fileHelper = new FileHelper();
        Converter converter = new Converter();
        List<User> userList = converter.convertStringToUser(fileHelper.readFromFile());
        User deleteByIdUser = findById(id);
        if (Objects.isNull(deleteByIdUser)) {
            throw new UserNotFoundException();
        }
        List<User> updatedUsersList = userList.stream().filter(user -> !Objects.equals(id, user.getId())).toList();

        deleteAll();
        for (User user : updatedUsersList) {
            fileHelper.writeToFile(user.toString(), false);
        }
    }

    @Override
    public void deleteAll() {
        try {
            new FileOutputStream(FILE_PATH).close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }


}
