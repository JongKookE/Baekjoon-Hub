import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] before, next;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        before = new int[N];
        next = new int[N];
        visited = new boolean[N];

        for(int n = 0; n < N; n++){
            int value = Integer.parseInt(st.nextToken());
            before[n] = value;
            next[n] = value;
        }
        Arrays.sort(next);
        for(int i=0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(before[i] != next[j] || visited[j] ) continue;
                visited[j] = true;
                sb.append(j).append(" ");
                break;
            }
        }
        System.out.println(sb);
    }
}