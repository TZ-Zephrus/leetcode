package greedy;

import java.util.*;

public class wordInterval763 {
    public List<Integer> partitionLabels0(String s) {
        List<Integer> result = new ArrayList<>();
        int[][] arr = new int[26][2];
        for (int[] ints : arr) {
            Arrays.fill(ints, -1);
        }
        //找出所有字母的起止位置
        for (int i = 0; i < s.length(); i++) {
            arr[(s.charAt(i)-'a')][1] = i;
        }
        for (int i = s.length()-1; i >= 0; i--) {
            arr[(s.charAt(i)-'a')][0] = i;
        }
        //定义一个涵盖前面字母的最大边界
        Arrays.sort(arr, (o1, o2) -> o1[0]-o2[0]);
        //初始化
        int maxIndex = arr[0][1];
        int startIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == -1) {
                maxIndex = arr[i+1][1];
                startIndex = 0;
                continue;
            }
            if (arr[i][0] <= maxIndex) {
                maxIndex = Math.max(maxIndex, arr[i][1]);
            } else {
                //maxRange-startRange + 1 用于计算字符串长度
                result.add(maxIndex-startIndex+1);
                startIndex = arr[i][0];  //改变起点
                maxIndex = arr[i][1];
            }
        }
        //把最后一段也给记上
        result.add(s.length()-startIndex); //这里startRange是最后一段的开始索引。
        return result;
    }

    public List<Integer> partitionLabels(String s) {
        int maxIndex = 0;
        int startIndex = 0;
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            maxIndex = Math.max(maxIndex, map.get(s.charAt(i)));
            if (i == maxIndex) {
                result.add(i - startIndex + 1);
                startIndex = i + 1;
            }
        }
        return result;
    }
}
