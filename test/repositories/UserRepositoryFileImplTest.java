package repositories;

import module.User;
import org.junit.jupiter.api.*;
import utils.Converter;
import utils.FileHelper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryFileImplTest {
        private UserRepositoryFileImpl userRepositoryFile;

    private final User TEST_USER = new User(
                "login",
                "password123",
                "password123",
                "testLastName",
                "testName",
                "testMiddleName",
                25,
                true
        );

        @BeforeAll
        static void setup() {
        }

        @BeforeEach
        void setupEach() {
            FileHelper fileHelper = new FileHelper();
            Converter converter = new Converter();
            userRepositoryFile = new UserRepositoryFileImpl();
        }

        @AfterAll
        static void cleanUp() {
            // Any cleanup that needs to be done once after all tests
        }

        @Test
        @DisplayName("Проверка успешного создания User")
        void create() {

            userRepositoryFile.create(TEST_USER);


            List<User> userList = userRepositoryFile.findAll();
            assertNotNull(userList);
            assertEquals(1, userList.size());
            assertEquals(TEST_USER, userList.get(0));
        }


    @Test
    @DisplayName("Поиск пользователя по идентификатору")
    void findById() {
        userRepositoryFile.create(TEST_USER);

        User foundUser = userRepositoryFile.findById(TEST_USER.getId());

        assertNotNull(foundUser);
        assertEquals(TEST_USER, foundUser);
    }

    @Test
    void findAll() {
        userRepositoryFile.create(TEST_USER);
        User anotherUser = new User(
                "anotherLogin",
                "password123",
                "password123",
                "anotherLastName",
                "anotherName",
                "anotherMiddleName",
                30,
                false
        );
        userRepositoryFile.create(anotherUser);

        List<User> userList = userRepositoryFile.findAll();

        assertNotNull(userList);
        assertEquals(2, userList.size());
        assertTrue(userList.contains(TEST_USER));
        assertTrue(userList.contains(anotherUser));
    }

    @Test
    @DisplayName("Обновление пользователя")
    void update() {
        User initialUser = new User(
                "existingLogin",
                "password123",
                "password123",
                "initialLastName",
                "initialName",
                "initialMiddleName",
                30,
                true
        ); userRepositoryFile.create(initialUser);

        User updatedUser = new User(
                initialUser.getId(),
                "updatedLogin",
                "newPassword",
                "newPassword",
                "updatedLastName",
                "updatedName",
                "updatedMiddleName",
                35,
                false
        );
        User result = userRepositoryFile.update(updatedUser);

        assertNotNull(result);
        assertEquals(updatedUser, result);

        List<User> userList = userRepositoryFile.findAll();
        assertNotNull(userList);
        assertEquals(1, userList.size());
        assertEquals(updatedUser, userList.get(0));
    }

    @Test
    @DisplayName("Удаление пользователя по ID")
    void deleteById() {
        // Arrange
        User userToDelete = new User(
                "deleteMeLogin",
                "password123",
                "password123",
                "deleteMeLastName",
                "deleteMeName",
                "deleteMeMiddleName",
                28,
                true
        );
        userRepositoryFile.create(userToDelete);

        assertDoesNotThrow(() -> userRepositoryFile.deleteById(userToDelete.getId()));

        List<User> userList = userRepositoryFile.findAll();
        assertNotNull(userList);
    }

    @Test
    @DisplayName("Удаление всех пользователей")
    void deleteAll() {
        User user1 = new User(
                "user1",
                "password1",
                "password1",
                "Last1",
                "First1",
                "Middle1",
                25,
                true);

        User user2 = new User(
                "user2",
                "password2",
                "password2",
                "Last2",
                "First2",
                "Middle2",
                30,
                false);

        userRepositoryFile.create(user1);
        userRepositoryFile.create(user2);
        assertDoesNotThrow(() -> userRepositoryFile.deleteAll());
        List<User> userList = userRepositoryFile.findAll();
        assertNotNull(userList);
    }

}