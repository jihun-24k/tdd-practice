package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {
    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨(){
        LocalDate billingDate = LocalDate.of(2023, 3,1);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertEquals(LocalDate.of(2023,4,1), expiryDate);

        LocalDate billingDate2 = LocalDate.of(2023, 5,5);
        int payAmount2 = 10_000;

        LocalDate expiryDate2 = cal.calculateExpiryDate(billingDate2, payAmount2);

        assertEquals(LocalDate.of(2023,6,5), expiryDate2);
    }
}
