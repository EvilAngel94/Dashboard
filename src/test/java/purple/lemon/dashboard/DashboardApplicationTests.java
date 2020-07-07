package purple.lemon.dashboard;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DashboardApplicationTests {

    @Test
    void contextLoads() {
        // demo purpose
        int solution = 10;
        assertEquals(solution, 5 + 5);
    }

}
