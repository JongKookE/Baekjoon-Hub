class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];

        for(int i = 0; i < size; i++){
            int cnt = 0;
            for(int j = i+1; j < size; j++){
                cnt++;
                if(prices[i] > prices[j]){
                    answer[i] = cnt;
                    break;
                }
            }
            if(answer[i] == 0) answer[i] = size - i - 1;
        }


        return answer;
    }
}