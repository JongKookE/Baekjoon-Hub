import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N, result;
    static int[] weights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        for(int n = 0; n < N; n++) weights[n] = Integer.parseInt(br.readLine());
        weights = Arrays.stream(weights)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for(int n = 0; n < N; n++) result = Math.max(result, weights[n] * (n+1));

        System.out.println(result);
    }
}