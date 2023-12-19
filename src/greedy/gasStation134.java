package greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class gasStation134 {
    //合理思想
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int remainingGas = 0;
        int totalGas = 0;
        for (int i = 0; i < gas.length; i++) {
            remainingGas = remainingGas + gas[i] - cost[i];
            totalGas = totalGas + gas[i] - cost[i];
            if (remainingGas < 0) {
                start = i + 1;
                remainingGas = 0;
            }
        }
        if (totalGas < 0) return -1;
        return start;
    }


    //自己写的 和随想录思路基本一致 但想复杂了，循环多走了
    public int canCompleteCircuit0(int[] gas, int[] cost) {
        int start = 0;
        int remainingGas = 0;
        int step = 1;
        int[] gasgas = IntStream.concat(IntStream.of(gas), IntStream.of(gas)).toArray();
        int[] costcost = IntStream.concat(IntStream.of(cost), IntStream.of(cost)).toArray();
        for (int i = 0; i < gasgas.length; i++) {
            if (step == gas.length+1) return start;
            remainingGas = remainingGas + gasgas[i] - costcost[i];
            if (remainingGas < 0) {
                //从下一个站重新开始
                //一切恢复初始
                step = 0;
                start = i+1;
                remainingGas = 0;
            }
            step++;
        }
        return -1;
    }
}
