package hot100.array;

import java.util.*;

public class zimuyiwei49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String string = new String(arr);
            List<String> list = map.getOrDefault(string, new ArrayList<String>());
            list.add(str);
            map.put(string, list);
        }
        return new ArrayList<>(map.values());
    }
}
