class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int sum = brown + yellow;
        for(int i=1; i<sum; i++){
            if(yellow%i != 0){
                continue;
            }
            if((yellow/i+i)*2+4 == brown){
                answer[0] = Math.max(yellow/i, i)+2;
                answer[1] = Math.min(yellow/i, i)+2;
                break;
            }        
    }
        return answer;
    }
}