import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int line = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		int[] memoi = new int[limit + 1];
		
		for(int i = 1; i <= line; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			for(int j = limit; j >= weight; j--) {								
				memoi[j] = Math.max(memoi[j], memoi[j - weight] + value);
			}
		}
		
		System.out.println(memoi[limit]);
	}
}
