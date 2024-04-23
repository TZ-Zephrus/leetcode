import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import backtrack.arangeRoute332;
import backtrack.test332;
import backtrack.solveSudoku37;
import greedy.hopGame55;
import greedy.nonOverlapping435;
import greedy.wordInterval763;
import greedy.mergeInterval56;
import dynamic_programming.staircase70;
import backtrack.coins322;
import dynamic_programming.differentPathTWO63;
import dynamic_programming.targetSum494;
import dynamic_programming.coinsTWO518;
import dynamic_programming.wordBreak139;
import dynamic_programming.buyStock121;
import dynamic_programming.longestIncreasing300;
import dynamic_programming.longestSharedSeq1143;
import dynamic_programming.judgeSubSeq392;
import dynamic_programming.distinctSeq115;
import hot100.array.longestSeq128;

public class test1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4}; // 示例数组
        int result = maximizeZeros(array);
        System.out.println("最大末尾0的数量：" + result);
    }

    public static int maximizeZeros(int[] array) {
        int maxTrailingZeros = 0;
        int indexToIncrement = -1;
        int currentTrailingZeros;

        // 遍历数组，找到末尾0最多的情况
        for (int i = 0; i < array.length; i++) {
            currentTrailingZeros = countTrailingZeros(array[i] + 1);
            if (currentTrailingZeros > maxTrailingZeros) {
                maxTrailingZeros = currentTrailingZeros;
                indexToIncrement = i;
            }
        }

        // 如果找到可以增加的元素，执行增加操作
        if (indexToIncrement != -1) {
            array[indexToIncrement]++;
        }

        // 计算操作后的数组乘积的末尾0的数量
        return countTrailingZerosOfProduct(array);
    }

    // 计算一个数的二进制表示中末尾0的数量
    private static int countTrailingZeros(int number) {
        int trailingZeros = 0;
        while (number % 2 == 0) {
            trailingZeros++;
            number /= 2;
        }
        return trailingZeros;
    }

    // 计算数组所有元素乘积的二进制表示中末尾0的数量
    private static int countTrailingZerosOfProduct(int[] array) {
        int totalTrailingZeros = 0;
        for (int value : array) {
            totalTrailingZeros += countTrailingZeros(value);
        }
        return totalTrailingZeros;
    }
}