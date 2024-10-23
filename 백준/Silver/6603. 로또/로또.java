import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int LOTTO = 6;
    static int[] target, src;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.countTokens() > 1){
            int N = Integer.parseInt(st.nextToken());
            target = new int[N];
            src = new int[LOTTO];
            visited = new boolean[N];
            for(int n = 0; n < N; n++) target[n] = Integer.parseInt(st.nextToken());
            getLotto(0, 0);
            System.out.println(sb.toString());
            sb.setLength(0);
            st = new StringTokenizer(br.readLine());
        }
    }
    static void getLotto(int start, int cnt){
        if(cnt == LOTTO){
            toStringBuilder(src);
            return;
        }
        for(int i = start; i < target.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            src[cnt] = target[i];
            getLotto(i, cnt+1);
            visited[i] = false;
        }
    }
    static void toStringBuilder(int[] src){
        for(int s: src) sb.append(s).append(" ");
        sb.append("\n");
    }
}