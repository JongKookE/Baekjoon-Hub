import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<int[]> dq = new ArrayDeque<>();
        for(int i = 0; i < progresses.length; i++) dq.add(new int[] {progresses[i], speeds[i]});
        while(!dq.isEmpty()){
            for(int[] group : dq){
                int speed = group[1];
                int[] result = dq.pollFirst();
                result[0] += speed;
                dq.addLast(result);
            }
            int count = 0;
            while(!dq.isEmpty() && dq.peekFirst()[0] >= 100){
                dq.pollFirst();
                count++;
            }
            if(count > 0) list.add(count);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}