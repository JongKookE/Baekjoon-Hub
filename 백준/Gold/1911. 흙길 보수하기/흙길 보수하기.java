import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static PriorityQueue<WaterHole> waterHolesPQ = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            waterHolesPQ.add(new WaterHole(start, end));
        }

        int start = 0;
        int result = 0;

        while(!waterHolesPQ.isEmpty()) {
            WaterHole waterHole = waterHolesPQ.poll();

            if(waterHole.end <= start) continue;

            start = Math.max(start, waterHole.start);
            int length = waterHole.end - start;
            int cnt = length % L == 0 ? length / L : length / L + 1;
            // start에서 cnt * L 만큼 더해준 값이 새로운 시작점
            start += cnt * L;
            result += cnt;
        }
        System.out.println(result);

    }
    static class WaterHole implements Comparable<WaterHole>{
        int start, end;

        public WaterHole(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(WaterHole o){
            return this.start == o.start ? o.end - this.end : this.start - o.start;
        }

        @Override
        public String toString() {
            return "WaterHole{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}