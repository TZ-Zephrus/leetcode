package dynamic_programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class wordBreak139 {

    //记忆化回溯
    HashSet<String> hashSet;
    int[] memo;
    public boolean wordBreak0(String s, List<String> wordDict) {
        hashSet = new HashSet<>(wordDict);
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return backtrack(s, 0);
    }

    private boolean backtrack(String s, int startIndex) {
        if (startIndex == s.length()) {
            return true;
        }
        if (memo[startIndex] == 0) {
            return false;
        }
        for (int i = startIndex+1; i <= s.length(); i++) {
            String substring = s.substring(startIndex, i);
            boolean contains = hashSet.contains(substring);
            if (!contains) {
                continue;
            }
            //这里如果返回值为true,说明从该点往后的子串，都能在set中找到
            boolean backtrack = backtrack(s, i);
            if (backtrack) return true;
        }
        //没有返回，说明找不到
        memo[startIndex] = 0;
        return false;
    }


    //dp
    public boolean wordBreak(String s, List<String> wordDict) {
        //不需要hs
//        HashSet<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < wordDict.size(); i++) {
                int len = wordDict.get(i).length();
                if (j >= len) {
                    //substring处的j必须先加一，这样j-单词长度之后，才能指向该单词在s中的起始位置。
                    dp[j] = dp[j-len] && wordDict.get(i).equals(s.substring(j-len, j));
//                    System.out.println(dp[j-wordDict.get(i).length()]);
//                    System.out.println(s.substring(j-wordDict.get(i).length(), j));
                }
                //这里的break非常重要，不加的话正确的dp[j]会被覆盖
                if (dp[j]) break;
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[s.length()];
    }
}

