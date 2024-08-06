import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] array, result;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        result = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) array[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int n = 0; n < N; n++) dfs(n, n);
        for(int[] arr: result){
            for(int v: arr) sb.append(v).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);

    }
    static void dfs(int x, int depth){
        for(int n = 0; n < N; n++){
            int num = array[x][n];
            if(num == 0) continue;
            if(visited[depth][n]) continue;
            visited[depth][n] = true;
            result[depth][n] = 1;
            dfs(n, depth);
        }
    }
}