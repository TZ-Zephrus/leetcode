package backtrack;

import java.util.*;
import java.util.function.BiConsumer;

public class arangeRoute332 {
    List<String> result = new LinkedList<>();
    boolean[] used;

    //事先将数组进行排序，然而这种方法会超时，需要优化
    public List<String> findItinerary(List<List<String>> tickets) {
        //将数组进行排序
        tickets.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        int a1 = o1.get(i).charAt(j) - 'a';
                        int a2 = o2.get(i).charAt(j) - 'a';
                        if (a1 != a2) {
                            return a1 - a2;
                        }
                    }
                }
                return 0;
            }
        });
        int routeLength = tickets.size();
        used = new boolean[tickets.size()];
        Arrays.fill(used, false);
        //设置出发点
        result.add("JFK");
        if (!backtrack(tickets, routeLength)) {
            result = new ArrayList<>();
        }
        return result;

    }

    private boolean backtrack(List<List<String>> tickets, int routeLength) {
        if (result.size() == routeLength + 1) {
            return true;
        }
        //递归查找路径
        for (int i = 0; i < tickets.size(); i++) {
            if (used[i]) continue;
            if (!result.get(result.size() - 1).equals(tickets.get(i).get(0))) continue;
            result.add(tickets.get(i).get(1));
            used[i] = true;
            if (backtrack(tickets, routeLength)) {
                return true;
            }
            used[i] = false;
            result.remove(result.size() - 1);
        }
        return false;
    }


    //将数组换为map集合,用Treemap保证有序
    Map<String, Map<String, Integer>> treeMap = new TreeMap<>();
    List<String> path;

    public List<String> findItinerary0(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (treeMap.containsKey(ticket.get(0))) {
                Map<String, Integer> map = treeMap.get(ticket.get(0));
                int value = map.getOrDefault(ticket.get(1), 0);
                map.put(ticket.get(1), value + 1);
                treeMap.put(ticket.get(0), map);
            } else {
                Map<String, Integer> map = new TreeMap<>();
                map.put(ticket.get(1), 1);
                treeMap.put(ticket.get(0), map);
            }
        }
        path = new LinkedList<>();
        int routeLength = tickets.size();
        path.add("JFK");
        if (!backtrack0(treeMap, routeLength)) {
            path = new ArrayList<>();
            return path;
        }
        return path;
    }

    private boolean backtrack0(Map<String, Map<String, Integer>> treeMap, int routeLength) {
        if (path.size() == routeLength + 1) {
            return true;
        }
        if (treeMap.containsKey(path.get(path.size() - 1))) {
            Map<String, Integer> map = treeMap.get(path.get(path.size() - 1));
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                int value = entry.getValue();
                if (value == 0) continue;
                path.add(entry.getKey());
                entry.setValue(value - 1);
                if (backtrack0(treeMap, routeLength)) {
                    return true;
                }
                entry.setValue(value);
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}