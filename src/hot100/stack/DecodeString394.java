package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-11
 */
public class DecodeString394 {
    Deque<String> deque;
    int startIndex = 0;
    public String decodeString(String s) {
        deque = new ArrayDeque<>();
        startIndex = 0;
        String result = "";
        while (startIndex < s.length()) {
            String decode = decode(s);
            result = result + decode;
        }
        return result;
    }
    public String decode(String s) {
        String str = "";
        StringBuilder sb = new StringBuilder();
        while ('0' <= s.charAt(startIndex) && '9' >= s.charAt(startIndex)) {
            sb.append(s.charAt(startIndex));
            startIndex++;
        }
        int times = 0;
        if (sb.toString().equals("")) {
            times = 1;
        } else {
            times = Integer.valueOf(sb.toString());
            startIndex++;  // 越过'['
        }

        while (startIndex < s.length() && s.charAt(startIndex) != ']') {
            if (s.charAt(startIndex) >= 'a' && s.charAt(startIndex) <= 'z') {
                str = str + s.charAt(startIndex);
                startIndex++;
            } else {
                str = str + decode(s);
            }
        }
        startIndex++;  // 越过']'
        String res = "";
        for (int i = 0; i < times; i++) {
            res = res + str;
        }
        return res;
    }


    // 简洁方法 递归
    int index = 0;
    public String decodeString2(String s) {
        return dfs(s);
    }
    private String dfs(String s) {
        int times = 0;
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            if ('0' <= s.charAt(index) && '9' >= s.charAt(index)) {
                times = 10 * times + Integer.valueOf(String.valueOf(s.charAt(index)));
            } else if (s.charAt(index) == '[') {
                index++;
                String sub = dfs(s);
                for (int i = 0; i < times; i++) {
                    sb.append(sub);
                }
                times = 0;
            } else if (s.charAt(index) == ']') {   // 这个条件仅对递归嵌套的dfs函数有用，因为最外层的会跳过']'
                return sb.toString();
            } else {
                sb.append(s.charAt(index));
            }
            index++;
        }
        return sb.toString();
    }


    public String decodeString3(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            else res.append(c);
        }
        return res.toString();
    }
}
