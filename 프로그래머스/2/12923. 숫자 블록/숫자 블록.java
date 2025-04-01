import java.util.Arrays;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        int index = 0;
        for(long i = begin; i <= end; i++){
            if(i == 1){
                answer[index++] = 0;
                continue;
            }
            answer[index++] = (int) getValue(i);

        }
        return answer;
    }

    long getValue(long number){
        long result = 1;
        for(long i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) {
                result = i;
                if(number / i <= 10_000_000) return number/i;
            }
        }
        return result;
    }
}
