import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result, last;
    static int[] diff;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        diff = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) diff[n] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) diff[n] = Integer.parseInt(st.nextToken()) - diff[n];
        prettier();
        System.out.println(result);

    }

    static void prettier(){
        for(int n = 1; n < N; n++){
            int previous = diff[n-1];
            int current = diff[n];
            if(current * previous < 0) result += Math.abs(previous);
            else if(Math.abs(previous) >= Math.abs(current)) result += Math.abs(previous) - Math.abs(diff[n]);
        }
        result += Math.abs(diff[N-1]);
    }
}