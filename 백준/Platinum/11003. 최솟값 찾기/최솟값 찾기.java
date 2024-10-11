import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.Deque;

public class Main {
    static int N, L;
    static StringBuilder sb = new StringBuilder();
    static Deque<Node> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int current = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && dq.peekLast().num > current) dq.pollLast();
            dq.addLast(new Node(i, current));
            if(!dq.isEmpty() && dq.peekFirst().index == i - L) dq.pollFirst();
            sb.append(dq.peekFirst().num).append(" ");
        }
        System.out.println(sb.toString());
    }
    static class Node{
        int index, num;
        public Node(int index, int num){
            this.index = index;
            this.num = num;
        }
        @Override
        public String toString(){
            return String.format("[index: %d, num: %d]", this.index, this.num);
        }
    }
}