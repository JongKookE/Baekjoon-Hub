import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int INF = Integer.MAX_VALUE;
    int[] dist;
    PriorityQueue<Node> pq;
    ArrayList<ArrayList<Node>> nodes;
    public int solution(int N, int[][] road, int K) {
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
         nodes = new ArrayList<>();
        for(int n = 0; n <= N; n++) nodes.add(new ArrayList<>());

        for(int[] unwrap : road){
            int from = unwrap[0];
            int to = unwrap[1];
            int distance = unwrap[2];

            nodes.get(from).add(new Node(to, distance));
            nodes.get(to).add(new Node(from, distance));
        }

        return dijkstra(K);
    }

    int dijkstra(int K){
        pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        int answer = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int current = node.to;
            int currentDistance = node.distance;
            if(currentDistance > dist[current]) continue;

            for(Node nextNode : nodes.get(current)){
                int next = nextNode.to;
                int cost = nextNode.distance;
                if(dist[next] > currentDistance + cost){
                    dist[next] = currentDistance + cost;
                    pq.add(new Node(next, dist[next]));
                }
            }
        }

        for(int distance : dist){
            if(distance > K) continue;
            answer++;
        }
        return answer;
    }


    class Node implements Comparable<Node> {
        int to, distance;

        public Node(int to, int distance){
            this.to = to;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", distance=" + distance +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
