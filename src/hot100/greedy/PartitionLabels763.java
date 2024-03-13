package hot100.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-13
 */
public class PartitionLabels763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int maxIndex = 0;
        List<Integer> result = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            maxIndex = Math.max(maxIndex, map.get(s.charAt(i)));
            length++;
            if (i == maxIndex) {
                result.add(length);
                length = 0;
            }
        }
        return result;
    }
}
