package string;

public class zhaochuxiabiaoKMP28 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int i = 0;  //用于跟踪文本串;
        int j = 0;  //用于跟踪模式串;
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next,needle);
        for (i = 0; i < haystack.length(); i++) {
            //不等的时候，利用next，j后退到合适位置继续匹配
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            //相等时，继续匹配
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //匹配完成
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

//    public static void getNext(int[] next, String s){
//        //初始化
//        next[0] = 0;
//        int j = 0;
//        for (int i = 1; i < s.length(); i++) {
//            //不相等时
//            while (j>0 && s.charAt(j) != s.charAt(i)) {
//                j = next[j-1];
//            }
//            //相等时
//            if (s.charAt(j) == s.charAt(i)) {
//                j++;
//            }
//            next[i] = j;
//        }
//    }
    public static void getNext(int[] next, String s){
        //初始化
        int j = 0;
        next[0] = j;
        for (int i = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j-1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }
}
