import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			dp[i] = array[i];
			for(int j = 1; j <= i; j++){
				if(array[i] > array[j]) dp[i] = Math.max(array[i] + dp[j], dp[i]);
			}
		}
		for(int d: dp) max = Math.max(max, d);
		System.out.println(max);
	}

}