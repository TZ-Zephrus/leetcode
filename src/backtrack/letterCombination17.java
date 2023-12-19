package backtrack;

import java.util.ArrayList;
import java.util.List;

public class letterCombination17 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int length = digits.length();
        if (digits.isEmpty()) {
            result.add("");
            return result;
        }
        backtrack(table, digits, 0);
        return result;
    }

    public void backtrack(String[] table, String digits, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int tableIndex = digits.charAt(index) - 48;
        for (int i = 0; i < table[tableIndex].length(); i++) {
            sb.append(table[tableIndex].charAt(i));
            backtrack(table, digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
