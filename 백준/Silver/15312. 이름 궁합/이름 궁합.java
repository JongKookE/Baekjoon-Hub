import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int[] alphabetCounts = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String myName = br.readLine();
        String herName = br.readLine();

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < myName.length(); i++) {
            dq.addLast(alphabetCounts[myName.charAt(i)-'A']);
            dq.addLast(alphabetCounts[herName.charAt(i)-'A']);
        }

        while(dq.size() > 2){
            for(int i = 0; i < dq.size(); i++){
                int number = dq.pollFirst() + dq.peekFirst();
                dq.addLast(number % 10);
            }
            dq.pollLast();
        }

        System.out.println(dq.pollFirst() + "" + dq.pollFirst());

    }
}