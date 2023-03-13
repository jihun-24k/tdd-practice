package chap02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        int result = meter.meter("ab12!@AB");
        assertEquals(2, result);
    }
}
