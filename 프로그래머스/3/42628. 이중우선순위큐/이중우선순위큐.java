import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution{
    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for(String operation : operations) {
            st = new StringTokenizer(operation);
            char op = st.nextToken().charAt(0);
            int value = Integer.parseInt(st.nextToken());
            if (op == 'I') {
                maxPQ.add(value);
                minPQ.add(value);
            }
            else{
                if (value == 1) minPQ.remove(maxPQ.poll());
                else maxPQ.remove(minPQ.poll());
            }
        }
        if(!maxPQ.isEmpty()) answer[0] = maxPQ.peek();
        if(!minPQ.isEmpty()) answer[1] = minPQ.peek();
        return answer;
    }
}