import java.util.*;

class Solution {
    ArrayList<ArrayList<Integer>> graph;
    boolean[] visited;
    public int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        visited = new boolean[n+1];
        for(int[] e: edge){
            int from = e[0];
            int to = e[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
//            for(ArrayList<Integer> list: graph) System.out.println(list);

        return bfs();
    }
    int bfs(){
        Deque<Node> dq = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        dq.addLast(new Node(1, 1));
        visited[1] = true;
        int answer = 0;
        while(!dq.isEmpty()){
            Node node = dq.pollFirst();
            int current = node.number;
            int time = node.time;
            answer = Math.max(answer, time);
            for(int nextNode: graph.get(current)){
                if(visited[nextNode]) continue;
                visited[nextNode] = true;
                dq.addLast(new Node(nextNode, time+1));
                pq.add(time+1);
            }
        }
        int cnt = 0;
        while(!pq.isEmpty() && pq.poll() == answer){
            cnt++;
        }
        return cnt;
    }
    class Node{
        int number, time;
        public Node(int number, int time){
            this.number = number;
            this.time = time;
        }
    }
}