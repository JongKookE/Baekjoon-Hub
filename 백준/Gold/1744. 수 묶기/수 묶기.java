import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> plusPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> minusPQ = new PriorityQueue<>();
        long sum = 0L;
        N = Long.parseLong(br.readLine());
        for(int n = 0; n < N; n++){
            long num = Long.parseLong(br.readLine());
            if(num > 0) plusPQ.add(num);
            else minusPQ.add(num);
        }

        if(N == 0){
            System.out.println(0);
            return;
        }

        sum += getPQSum(plusPQ);
        sum += getPQSum(minusPQ);

        if(!minusPQ.isEmpty()) sum += minusPQ.poll();
        if(!plusPQ.isEmpty()) sum += plusPQ.poll();

        System.out.println(sum);

    }

    static long getPQSum(PriorityQueue<Long> pq){
        long sum = 0;
        while(pq.size() >= 2){
            long current = pq.poll();
            long next = pq.poll();
            sum += Math.max(current * next, current + next);
        }
        return sum;
    }
}