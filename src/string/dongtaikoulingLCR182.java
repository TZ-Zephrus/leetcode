package string;

public class dongtaikoulingLCR182 {
    public static void main(String[] args) {
        String password = "s3cur1tyC0d3";
        int target = 4;
        System.out.println(dynamicPassword(password, target));
    }

    public static String dynamicPassword2(String password, int target) {
        char[] arr = new char[password.length()*2];
        for (int i = 0; i < password.length(); i++) {
            arr[i] = password.charAt(i);
        }
        int i = 0;
        while (i < target) {
            arr[password.length() + i] = arr[i];
            i++;
        }
        return new String(arr, target, password.length());
    }

    //方法2 颠倒法
    public static String dynamicPassword(String password, int target) {
        StringBuilder sb = new StringBuilder(password);
        reverse(sb, 0, target-1);
        reverse(sb, target, password.length()-1);
        reverse(sb, 0, password.length()-1);
        return sb.toString();
    }
    public static void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
