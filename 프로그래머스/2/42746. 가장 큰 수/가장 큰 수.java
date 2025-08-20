import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>(
                (s1, s2) -> (s2+s1).compareTo(s1+s2)
        );

        for(int number : numbers) pq.add(String.valueOf(number));
        while(!pq.isEmpty()) answer.append(pq.poll());
        return answer.toString().charAt(0) == '0' ? "0" : answer.toString();
    }
}