import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for(int n = 1; n <= N; n++) dq.addLast(n);
        sb.append("<");
        int iter = 1;
        while(!dq.isEmpty()) {
            if(iter % K == 0) sb.append(dq.pollFirst()).append(", ");
            else dq.addLast(dq.pollFirst());
            iter++;
        }
        sb.setLength(sb.length()-2);
        sb.append(">");
        System.out.println(sb);
    }
}