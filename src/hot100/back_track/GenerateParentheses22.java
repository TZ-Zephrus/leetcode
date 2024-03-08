package hot100.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-08
 */
public class GenerateParentheses22 {
    List<String> result;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        sb = new StringBuilder();
        char[] arr = {'(', ')'};
        int leftNumber;   // 用于记录已存在的左括号数量
        backtrack(arr, n, 0);
        return result;
    }
    public void backtrack(char[] arr, int n, int leftNumber) {
        if (sb.length() == n*2) {
            if (leftNumber == 0) {
                result.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i == 0) {
                leftNumber++;
            } else {
                leftNumber--;
            }
            if (leftNumber >= 0 && leftNumber <= n) {
                backtrack(arr, n, leftNumber);
            }
            if (i == 0) {
                leftNumber--;
            } else {
                leftNumber++;
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
