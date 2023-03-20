package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.length() == 0) {
            return PasswordStrength.INVALID;
        }
        int meetCounts = getMetCriteriaCounts(s);

        if (meetCounts <= 1) return PasswordStrength.WEAK;
        if (meetCounts == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int meetCounts = 0;
        if(s.length() >= 8) meetCounts++;
        if(meetsContainingNumberCriteria(s)) meetCounts++;
        if (meetsContainingUppercaseCriteria(s)) meetCounts++;
        return meetCounts;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch))
                return true;
        }
        return false;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9')
                return true;
        }
        return false;
    }
}
