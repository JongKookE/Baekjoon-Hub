import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int N;
    static int[] arr;
    static Deque<Integer> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int n = 0; n < N; n++) arr[n] = Integer.parseInt(br.readLine());

        int num = 1;
        for(int n = 0; n < N; n++) {
            int currentSequenceNumber = arr[n];
            if(currentSequenceNumber >= num) {
                while(currentSequenceNumber >= num) {
                    stack.addLast(num++);
                    sb.append("+").append("\n");
                }
                stack.removeLast();
                sb.append("-").append("\n");
            }
            else{
                int last = stack.removeLast();
                // stack 내부에는 tail보다 모든 원소가 더 작다
                // 현재 수열의 수가 tail보다 크다면 해당 수열은 만들 수 없음
                if(currentSequenceNumber > last) {
                    System.out.println("NO");
                    return;
                }
                else if(currentSequenceNumber == last) sb.append("-").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}