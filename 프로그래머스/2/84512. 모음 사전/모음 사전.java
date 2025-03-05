import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    PriorityQueue<String> pq = new PriorityQueue<>();
    StringBuilder sb = new StringBuilder();
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        makeVowelDict(0);
        pq.addAll(list);
        int cnt = 0;
        while(!pq.isEmpty()) {
            cnt++;
            String beCompared = pq.poll();
            if(!word.equals(beCompared)) continue;
            return cnt;
        }
        return cnt;
    }
    void makeVowelDict(int depth){
        if(depth == 5) return;
        for(int d = 0; d < 5; d++){
            char ch = vowels[d];
            sb.append(ch);
            list.add(sb.toString());
            makeVowelDict(depth+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}