package hot100.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-14
 */
public class PascalsTriangle118 {
    // 数学方法
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        result.add(firstList);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    list.add(result.get(i-1).get(j));
                } else if (j == i) {
                    list.add(result.get(i-1).get(j-1));
                } else {
                    list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    // 动态规划

}
