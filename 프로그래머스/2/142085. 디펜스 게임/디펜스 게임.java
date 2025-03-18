import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int enemyCount: enemy){
            n -= enemyCount;
            pq.add(enemyCount);
            answer++;
            if(n >= 0) continue;
            if(k == 0) return --answer;
            k--;
            n += pq.poll();
        }
        return answer;
    }
}