import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(String data : info){
            String[] div = data.split(" ");
            dfs("", 0, map, div);
        }

        for(ArrayList<Integer> list : map.values()) list.sort(Comparator.comparingInt(Integer::intValue));

        for(int i = 0; i < query.length; i++){
            String str = query[i];
            StringTokenizer st = new StringTokenizer(str);
            StringBuilder sb = new StringBuilder();
            while(st.countTokens() != 1){
                String part = st.nextToken();
                if(part.equals("and")) continue;
                sb.append(part);
            }
            int target = Integer.parseInt(st.nextToken());

            ArrayList<Integer> scores = map.getOrDefault(sb.toString(), new ArrayList<>());
            if(scores.isEmpty()) {
                answer[i] = 0;
                continue;
            }
            int targetIndex = binarySearch(scores, target);
            answer[i] = scores.size() - targetIndex;
        }
        return answer;
    }

    int binarySearch(ArrayList<Integer> scores, int targetScore){
        int start = 0;
        int end = scores.size();
        while(start < end){
            int mid = (end + start)/2;
            int currentScore = scores.get(mid);
            if(currentScore < targetScore) start = mid+1;
            else end = mid;
        }
        return start;
    }

    void dfs(String key, int depth, HashMap<String, ArrayList<Integer>> map, String[] info){
        if(depth == 4){
            int score = Integer.parseInt(info[4]);
            map.computeIfAbsent(key, arr -> new ArrayList<>()).add(score);
            return;
        }
        dfs(key + info[depth], depth+1, map, info);
        dfs(key + "-", depth+1, map, info);
    }
}
