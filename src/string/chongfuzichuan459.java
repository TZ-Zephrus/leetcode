package string;

public class chongfuzichuan459 {
    public static void main(String[] args) {
        String s = "abac";
        System.out.println(repeatedSubstringPattern(s));
    }


    //暴力方法，耗时很长
    public static boolean repeatedSubstringPattern2(String s) {
        int i = 0;
        int j = 1; //用于记录子串长度
        while (j <= s.length()/2) {
            i = 0;
            while (i < s.length()) {
                if (s.charAt(i%j) != s.charAt(i)) {
                    break;
                }
                if (i == s.length()-1 && i%j == j-1) {  //i == s.length()-1 用于判断走到了文本串串尽头，i%j == j-1用于判断走到了子串尽头，即把字串从头到尾都比完了
                    return true;
                }
                i++;
            }
            j++;
        }
        return false;
    }

    //kmp方法
    public static boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(next, s);
        return next[s.length()-1] != 0 && s.length() % (s.length() - next[s.length()-1]) == 0;
    }

    public static void getNext(int[] next, String s) {
        //初始化
        int j = 0;
        next[0] = 0;
        //开始i一层一层往后找
        for (int i = 1; i < s.length(); i++) {
            //不等时
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }
            //相等时
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }
}
