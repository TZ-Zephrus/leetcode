package greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class rebulidByHeight406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o2[0] != o1[0]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][]);
    }
}
