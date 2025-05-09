import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int HP = 99;
    static int[] happyScore, damageScore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer damageToken = new StringTokenizer(br.readLine());
        StringTokenizer happyToken = new StringTokenizer(br.readLine());

        int[] dp = new int[HP+1];

        damageScore = new int[N+1];
        happyScore = new int[N+1];

        for(int n = 0; n < N; n++){
            happyScore[n] = Integer.parseInt(happyToken.nextToken());
            damageScore[n] = Integer.parseInt(damageToken.nextToken());
        }

        for(int n = 0; n < N; n++){
            int damage = damageScore[n];
            int happy = happyScore[n];
            for(int maxHP = HP; maxHP >= damage; maxHP--){
                dp[maxHP] = Math.max(dp[maxHP], dp[maxHP-damage] + happy);
            }
        }
        System.out.println(dp[HP]);

    }
}
