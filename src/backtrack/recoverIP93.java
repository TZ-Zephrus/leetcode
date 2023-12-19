package backtrack;

import java.util.ArrayList;
import java.util.List;

public class recoverIP93 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 1);
        return result;
    }
    public void backtrack(String s, int startIndex, int number) {
        if (number == 4) {
            if (startIndex < s.length()) {
                String str = s.substring(startIndex);
                if (str.length() > 1 && str.charAt(0) == '0') {
                    return;
                }
                int strNum = 0;
                try {
                    strNum = Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    return;
                }
                if (0 <= strNum && strNum <= 255) {
                    sb.append(str);
//                    sb.append(".");
//                    result.add(sb.toString());
                    result.add(sb.toString());
                    sb.delete(sb.length() - str.length(), sb.length());
                }
            }
            return;
        }
        for (int i = startIndex+1; i <= startIndex+3 && i < s.length(); i++) {
            String str = s.substring(startIndex, i);
            if (str.length() > 1 && str.charAt(0) == '0') {
                return;
            }
            int strNum = 0;
            try {
                strNum = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return;
            }
            if (0 <= strNum && strNum <= 255) {
                sb.append(str);
                sb.append(".");
                backtrack(s, i, number+1);
                sb.deleteCharAt(sb.length() - 1);
                sb.delete(sb.length() - str.length(), sb.length());
            }
        }
    }
}
