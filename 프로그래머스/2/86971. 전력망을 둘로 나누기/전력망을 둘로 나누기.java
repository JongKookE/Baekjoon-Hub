import java.util.ArrayList;

class Solution {
    ArrayList<ArrayList<Integer>> graph;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        int size = wires.length;
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int i = 0; i < size; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println(graph);
        for(int i = 0; i < size; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            int countA = dfs(a, new boolean[n + 1]);
            int countB = n - countA;
            int diff = Math.abs(countA - countB);
            if(answer == -1) answer = diff;
            else answer = Math.min(answer, diff);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return answer;
    }
    int dfs(int node, boolean[] visited){
        visited[node] = true;
        int count = 1;
        for(int next : graph.get(node)){
            if(visited[next]) continue;
            count += dfs(next, visited);
        }
        return count;
    }
}
