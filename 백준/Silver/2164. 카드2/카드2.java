import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for(int n = 1; n <= N; n++) queue.addLast(n);
        while(queue.size() != 1){
            queue.removeFirst();
            queue.addLast(queue.removeFirst());
        }
        System.out.println(queue.removeFirst());
    }
}