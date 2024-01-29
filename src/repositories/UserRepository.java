package repositories;

import module.User;

import java.util.List;

public interface UserRepository {

    static final String FILE_PATH = "src/resources/input.txt";
    void create(User user);
    User findById(String id);
    List<User> findAll();
    User update(User user);
    void deleteById(String id);
    void deleteAll();
}
