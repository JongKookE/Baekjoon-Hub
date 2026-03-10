import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 0;
        for(int n = 1; n <= N; n++) arr[n] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        long result = 0;
        for(int n = 1; n <= N; n++){
            int expectedRank = arr[n];
            result += Math.abs(n - expectedRank);
        }
        System.out.println(result);

    }
}