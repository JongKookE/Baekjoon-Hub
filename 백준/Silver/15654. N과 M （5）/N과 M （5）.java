import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, src;
    static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 문자열을 띄어쓰기를 기준으로 String 배열로 만듬
        // 한글자씩 있는 문자열을 int로 변환하고 정렬후 Array로 변환
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        src = new int[M];
        visited = new boolean[N];
        nToM(0);
        System.out.println(sb.toString());
    }
    static void nToM(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++) sb.append(src[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            src[depth] = arr[i];
            nToM(depth + 1);
            visited[i] = false;
        }

    }
}