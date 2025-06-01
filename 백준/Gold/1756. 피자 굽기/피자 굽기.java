import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] ovenWidths = new int[D];

        st = new StringTokenizer(br.readLine());
        for(int d = 0; d < D; d++) {
            ovenWidths[d] = Integer.parseInt(st.nextToken());
            if(d == 0) continue;
            if(ovenWidths[d-1] <= ovenWidths[d]) ovenWidths[d] = ovenWidths[d-1];
        }

        int[] pizzaWidths = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) pizzaWidths[n] = Integer.parseInt(st.nextToken());

        int result = 0;
        int currentPizzaIndex = 0;

        for(int d = D-1; d >= 0; d--){
            if(ovenWidths[d] >= pizzaWidths[currentPizzaIndex]) currentPizzaIndex++;
            if(currentPizzaIndex == N){
                result = d + 1;
                break;
            }
        }
        System.out.println(result);
    }
}
