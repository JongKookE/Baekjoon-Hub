import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, S, result;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        Arrays.sort(numbers);
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) numbers[n] = Integer.parseInt(st.nextToken());
        findPartialSequence(0, 0);

        System.out.println(S == 0 ? result-1 : result);
    }
    static void findPartialSequence(int depth, int sum){
        if(depth == N){
            if(sum == S) result++;
            return;
        }
       findPartialSequence(depth+1, sum + numbers[depth]);
        findPartialSequence(depth+1, sum);
    }
}