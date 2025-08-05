import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for(int n = 1; n <= N; n++) dq.addLast(n);
        sb.append("<");
        int iter = 0;
        while(!dq.isEmpty()) {
            iter++;
            if(iter % K != 0) dq.addLast(dq.pollFirst());
            else sb.append(dq.pollFirst()).append(",").append(" ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb.append(">"));
    }
}
