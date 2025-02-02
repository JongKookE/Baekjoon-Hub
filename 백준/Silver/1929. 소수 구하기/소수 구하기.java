import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        visited[0] = visited[1] = true;
        // M 이상 N 이하의 소수 구하기
        for(int m = 2; m <= Math.sqrt(N); m++){
            if(visited[m]) continue;
            for(int i = m * m; i <= N; i += m) visited[i] = true;
        }
        for(int i = M; i <= N; i++) {
            if(visited[i]) continue;
            sb.append(i).append("\n");
        }
        System.out.println(sb);

    }
}