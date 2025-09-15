import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++){
            int date = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if(!dq.isEmpty() && dq.peek() < date){
                list.add(dq.size());
                dq.pollFirst();
                dq.clear();
            }

            dq.add(date);
        }
        list.add(dq.size());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}