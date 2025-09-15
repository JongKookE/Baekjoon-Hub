import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[3];
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        answer[0] = calcScore(answers, one);
        answer[1] = calcScore(answers, two);
        answer[2] = calcScore(answers, three);
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        for(int i = 0; i < answer.length; i++) if (answer[i] == max) list.add(i+1);

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    int calcScore(int[] answers, int[] pick){
        int answer = 0;
        for (int i = 0; i < answers.length; i++) {
            if (pick[i % pick.length] != answers[i]) continue;
            answer++;
        }
        return answer;
    }
}
