import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100_000;
    static int subin, brother;
    static int[] visited;
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        // visited 배열을 boolean이 아닌 int로 해야함
        // 해당 거리에 왔을때의 최소값을 기록하기 위한 배열
        visited = new int[MAX+1];
        hideAndSeek();
    }
    // 가중치가 0 또는 1인 0-1bfs
    // 가중치가 낮은 정점으로의 이동을 높은 우선순위로 해야하기 때문에 addLast가 아닌 addFirst로 큐에 삽입을 한다.
    static void hideAndSeek() {
        deque.addLast(subin);
        Arrays.fill(visited, -1);
        visited[subin] = 0;
        while(!deque.isEmpty()){
            int cur = deque.pollFirst();
            if(cur == brother){
                System.out.println(visited[brother]);
                return;
            }

            if(cur * 2 <= MAX && visited[cur*2] == -1){
                // 우선순위가 높기 때문에 큐의 제일 앞에 넣어줌
                deque.addFirst(cur*2);
                // 가중치가 0임
                visited[cur*2] = visited[cur];
            }

            if(cur > 0 && visited[cur-1] == -1){
                deque.addLast(cur-1);
                visited[cur-1] = visited[cur]+1;
            }

            if(cur < MAX && visited[cur+1] == -1){
                deque.addLast(cur+1);
                visited[cur+1] = visited[cur]+1;
            }
        }
    }
}