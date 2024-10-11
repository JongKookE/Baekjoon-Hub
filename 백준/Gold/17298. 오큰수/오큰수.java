import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] sequence, result;
    static Deque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        sequence = new int[N];
        result = new int[N];
        for(int i = 0; i < N; i++) sequence[i] = Integer.parseInt(st.nextToken());
        stack.addLast(0);
        for(int index = 0; index < N; index++) {
            int sequenceValue = sequence[index];
            while(!stack.isEmpty() && sequence[stack.getLast()] < sequenceValue){
                int poppedIndex = stack.removeLast();
                result[poppedIndex] = sequenceValue;
            }
            stack.addLast(index);
        }

        while(!stack.isEmpty()){
            int poppedIndex = stack.removeLast();
            result[poppedIndex] = -1;
        }
        System.out.println(getResult(result));
    }
    static private String getResult(int[] result){
        StringBuilder sb = new StringBuilder();
        Arrays.stream(result)
                .map(res -> res == 0 ? -1 : res) // res가 0이면 -1로 변환
                .forEach(res -> sb.append(res).append(" "));
        return sb.toString();
    }
}