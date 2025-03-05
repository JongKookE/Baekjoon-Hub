import java.util.Arrays;
class Solution{
    int solution(int[] players, int m, int k){
        int answer = 0;
        int[] dp = new int[players.length];
        Arrays.fill(dp, m-1);
        for(int index = 0; index < dp.length; index++){
            int currentPlayer = players[index];
            if(currentPlayer <= dp[index]) continue;
            int lastIndex = Math.min(dp.length-1, index+k-1);
            int requiredPersonCount = currentPlayer - dp[index];
            int requiredServerCount = (requiredPersonCount/m + 1);
            if(requiredPersonCount % m == 0) requiredServerCount--;
            for(int j = index; j <= lastIndex; j++) dp[j] += requiredServerCount * m;
            answer += requiredServerCount;
        }
        return answer;
    }
}