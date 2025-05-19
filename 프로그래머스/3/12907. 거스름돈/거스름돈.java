class Solution {
    static final int INF = 1_000_000_007;
    public int solution(int n, int[] money) {
        int answer = 0;
        int size = money.length;
        long[] dp = new long[n + 1];
        for(int i = 0; i < size; i++){
            int currentMoney = money[i];
            if(currentMoney > n) continue;
            dp[currentMoney]++;
            for(int j = 1; j <= n; j++){
                if(j - currentMoney < 0) continue;
                dp[j] += dp[j - currentMoney];
                dp[j] %= INF;
            }
        }
        return Integer.parseInt(String.valueOf(dp[n]));
    }
}
