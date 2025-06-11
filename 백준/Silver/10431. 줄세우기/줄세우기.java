import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int MAX = Integer.MIN_VALUE;
    static int[] lines = new int[21];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int index = 0; index < 20; index++) lines[index] = Integer.parseInt(st.nextToken());


            sb.append(n+1).append(" ").append(findMinGreaterThan()).append("\n");
        }
        System.out.println(sb);
    }
    static int findMinGreaterThan(){
        int result = 0;
        for(int i = 0; i < 20; i++){
            int comparedValue = lines[i];
            for(int j = 0; j < i; j++){
                int currnetValue = lines[j];
                if(comparedValue >= currnetValue) continue;
                result++;
            }
        }
        return result;
    }
}
