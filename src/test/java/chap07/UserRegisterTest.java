package chap07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRegisterTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubPasswordChecker, fakeRepository);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        stubPasswordChecker.setWeak(true);

        assertThrows(WeakPasswordException.class, () -> {userRegister.register("id","pw","email");});
    }

    @DisplayName("이미 같은 ID가 존재하면 가입 실패")
    @Test
    void dupIdExists() {
        fakeRepository.save(new User("id","pw1","email@email.com"));

        assertThrows(DupIdException.class, () -> {userRegister.register("id","pw","email");});
    }

    @DisplayName("같은 ID가 없으면 가입 성공")
    @Test
    void noDupId_RegisterSuccess(){
        userRegister.register("id", "pw", "email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }
}
