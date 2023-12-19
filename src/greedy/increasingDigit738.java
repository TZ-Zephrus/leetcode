package greedy;

public class increasingDigit738 {
    public int monotoneIncreasingDigits(int n) {
        if (n<10) {
            return n;
        }
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = chars.length;
        for (int i = chars.length-1; i > 0; i--) {
            if (chars[i-1] > chars[i]) {
                chars[i-1] = (char) (chars[i-1]-1);
                chars[i] = '9';
                start = i+1;
            }
        }
        for (int i = start; i < chars.length; i++) {
            chars[i] = 9;
        }
        return Integer.parseInt(String.copyValueOf(chars));
    }
}
