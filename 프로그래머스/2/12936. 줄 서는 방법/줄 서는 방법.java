import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }
        
        k--;
        int cnt = 0;
        while(n > 0){
            factorial /= n--;
            answer[cnt++] = list.get((int) (k/factorial));
            list.remove((int) (k/factorial));
            k %= factorial;
        }
        return answer;
    }
}