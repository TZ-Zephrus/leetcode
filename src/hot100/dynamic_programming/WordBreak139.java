package hot100.dynamic_programming;

import java.sql.Struct;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-18
 */
public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;
            for (int i = 1; i < s.length()+1; i++) {
                for (int j = 0; j < wordDict.size(); j++) {
                    int len = wordDict.get(j).length();
                    if (i >= len) {
                        dp[i] = dp[i-len] && wordDict.get(j).equals(s.substring(i-len, i));
                    }
                    // break很重要，防止true被覆盖
                    if (dp[i]) break;

                }
            }
            return dp[s.length()];
        }
}
