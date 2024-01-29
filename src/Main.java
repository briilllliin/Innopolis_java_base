import module.User;
import repositories.UserRepository;
import repositories.UserRepositoryFileImpl;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryFileImpl();

        User newUser = new User(
                "newLogin",
                "password123",
                "password123",
                "new",
                "login",
                "again",
                30,
                true
        );


        System.out.println("Создание нового пользователя...");
        userRepository.create(newUser);
        System.out.println(userRepository.findAll());

        System.out.println("\nПоиск пользователя по ID...");
        System.out.println("\nID - " + newUser.getId());
        User foundUser = userRepository.findById(newUser.getId());
        if (foundUser != null) {
            System.out.println("Пользователь найден: " + foundUser);
        } else {
            System.out.println("Пользователь не найден.");
        }

        System.out.println("\nОбновление пользователя...");
        User updatedUser = new User(
                newUser.getId(),
                newUser.getLogin(),
                "new_password",
                "new_password",
                "UpdatedLastName",
                "UpdatedFirstName",
                "UpdatedMiddleName",
                31,
                false
        );
        userRepository.update(updatedUser);
        System.out.println("Пользователь обновлен.");


        System.out.println("\nПоиск всех пользователей...");
        userRepository.findAll().forEach(System.out::println);


        System.out.println("\nУдаление пользователя по ID...");
        try {
            userRepository.deleteById(updatedUser.getId());
            System.out.println("Пользователь удален.");
        } catch (Exception e) {
            System.out.println("Ошибка при удалении пользователя: " + e.getMessage());
        }

        System.out.println("Создание нескольких пользователей...");
        for (int i = 0; i < 5; i++) {
            userRepository.create(new User());
        }
        User user1 = new User(
                "newLogin1",
                "password123",
                "password123",
                "new",
                "login",
                "again",
                30,
                true
        );
        User user2 = new User(
                "newLogin2",
                "password123",
                "password123",
                "new",
                "login",
                "again",
                30,
                true
        );
        User user3 = new User(
                "newLogin3",
                "password123",
                "password123",
                "new",
                "login",
                "again",
                30,
                true
        );
        userRepository.create(user1);
        userRepository.create(user2);
        userRepository.create(user3);
        System.out.println(userRepository.findAll());


        System.out.println("\nУдаление всех пользователей...");
        userRepository.deleteAll();
        System.out.println("Все пользователи удалены.");
    }


}
