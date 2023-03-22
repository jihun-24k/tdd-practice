package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmounts) {
        return billingDate.plusMonths(1);
    }
}
