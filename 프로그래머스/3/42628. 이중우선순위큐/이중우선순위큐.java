import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> findMin = new PriorityQueue<>();
        PriorityQueue<Integer> findMax = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for(String operation : operations){
            st = new StringTokenizer(operation);
            char command = st.nextToken().charAt(0);
            int number = Integer.parseInt(st.nextToken());
            switch(command){
                case 'I' -> insertNumber(number, findMin, findMax);
                case 'D' -> deleteNumber(number, findMin, findMax);
            }
        }
        if(findMin.isEmpty()) return new int[] {0, 0};
        return new int[] {findMax.poll(), findMin.poll()};
    }
    void insertNumber(int number, PriorityQueue<Integer> findMin, PriorityQueue<Integer> findMax){
        findMax.add(number);
        findMin.add(number);
    }

    void deleteNumber(int number, PriorityQueue<Integer> findMin, PriorityQueue<Integer> findMax){
        if(number == 1) findMin.remove(findMax.poll());
        else findMax.remove(findMin.poll());
    }
}