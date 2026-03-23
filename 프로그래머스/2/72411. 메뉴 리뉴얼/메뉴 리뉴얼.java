import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private final Map<String, Integer> countMap = new HashMap<>();
    private final Map<Integer, Integer> maxCountMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);

            for (int size : course) {
                if (size <= chars.length) {
                    comb(chars, 0, 0, size, new StringBuilder());
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String menu = entry.getKey();
            int count = entry.getValue();
            int length = menu.length();

            if(count < 2) continue;

            // 요리 count개 코스 일때 가장 많이 선택된 값
            if (count != maxCountMap.getOrDefault(length, 0)) continue;
            result.add(menu);
        }

        result.sort(String::compareTo);
        return result.toArray(new String[0]);
    }

    void comb(char[] chars, int start, int depth, int target, StringBuilder current) {
        if (depth == target) {
            String menu = current.toString();
            int nextCount = countMap.getOrDefault(menu, 0) + 1;
            countMap.put(menu, nextCount);
            maxCountMap.put(target, Math.max(maxCountMap.getOrDefault(target, 0), nextCount));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            current.append(chars[i]);
            comb(chars, i + 1, depth + 1, target, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
