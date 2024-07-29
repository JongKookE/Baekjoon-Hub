class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 1;
        int length = numbers.length;
        for(int i = 0; i < k-1; i++){
            answer += 2;
            if(answer > length) answer %= length;
            
        }
        return answer;
    }
}