import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
	static int N, max;
	static int[] dp, array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		array = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int n = 1; n <= N; n++) array[n] = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= N; i++){
			dp[i] = 1;
			for(int j = 1; j <= i; j++){
				if(array[i] > array[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}