package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {
    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨(){

        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2023,3,1)).payAmount(10_000).build(), LocalDate.of(2023, 4,1));
        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2023,5,5)).payAmount(10_000).build(), LocalDate.of(2023, 6,5));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음() {
        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2023,1,31)).payAmount(10_000).build(), LocalDate.of(2023, 2, 28));
        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2023,5,31)).payAmount(10_000).build(), LocalDate.of(2023, 6, 30));
        assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2024,1,31)).payAmount(10_000).build(), LocalDate.of(2024, 2, 29));
    }

    void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
