import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int count = 0;
        for(int[] command : commands){
            int start = command[0];
            int end = command[1];
            int k = command[2];

            int target = Arrays.stream(array, start-1, end)
                    .sorted()
                    .toArray()[k-1];
            answer[count++] = target;
        }
        return answer;
    }
}