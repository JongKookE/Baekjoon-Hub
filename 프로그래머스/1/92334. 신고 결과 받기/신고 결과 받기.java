import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        LinkedHashSet<String> set = new LinkedHashSet<>(List.of(report));
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < id_list.length; i++) map.put(id_list[i], i);
        StringTokenizer st;

        HashMap<String, Integer> reportCounter = new HashMap<>();
        for(String str : set){
            st = new StringTokenizer(str);
            st.nextToken();
            String rep = st.nextToken();
            reportCounter.put(rep, reportCounter.getOrDefault(rep, 0) + 1);
        }

        for(String rep : set){
            st = new StringTokenizer(rep);
            String reporter = st.nextToken();
            String reported = st.nextToken();

            if(reportCounter.getOrDefault(reported, 0) < k) continue;
            answer[map.get(reporter)]++;
        }

        return answer;
    }
}