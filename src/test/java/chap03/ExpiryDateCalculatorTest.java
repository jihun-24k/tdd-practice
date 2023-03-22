package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {
    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨(){

        assertExpiryDate(LocalDate.of(2023, 3,1), 10_000, LocalDate.of(2023, 4,1));
        assertExpiryDate(LocalDate.of(2023, 5,5), 10_000, LocalDate.of(2023, 6,5));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpiryDate(LocalDate.of(2023, 1, 31), 10_000, LocalDate.of(2023, 2, 28));
        assertExpiryDate(LocalDate.of(2023, 5, 31), 10_000, LocalDate.of(2023, 6, 30));
        assertExpiryDate(LocalDate.of(2024, 1, 31), 10_000, LocalDate.of(2024, 2, 29));
    }

    void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
