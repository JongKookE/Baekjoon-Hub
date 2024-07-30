import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> pq;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // vertex, edge
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        visited = new boolean[N+1];
        
        for(int n = 0; n <= N; n++) list.add(new ArrayList<>());

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }


        dijkstra();

    }

    static void dijkstra(){
        pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            for(Node next: list.get(node.vertex)){
                if(!visited[next.vertex] && dist[next.vertex] > dist[node.vertex] + next.cost){
                    dist[next.vertex] = dist[node.vertex] + next.cost;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        System.out.println(dist[N]);
    }

    static class Node{
        int vertex, cost;
        public Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "vertex=" + vertex +
                    ", cost=" + cost +
                    '}';
        }
    }
}