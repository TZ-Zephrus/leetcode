package hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-08
 */
public class CombinationOfPhoneNumber17 {
    List<String> result;
    StringBuilder sb;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        sb = new StringBuilder();
        backtrack(dict, digits, 0);
        return result;
    }
    public void backtrack(String[] dict, String digits, int startIndex) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int dictIndex = digits.charAt(startIndex) - '0';
        for (int i = 0; i < dict[dictIndex].length(); i++) {
            char c = dict[dictIndex].charAt(i);
            sb.append(c);
            backtrack(dict, digits, startIndex+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
