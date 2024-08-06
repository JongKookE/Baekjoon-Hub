import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, start;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        for(int n = 0; n <= N; n++) graph.add(new ArrayList<>());
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(ArrayList<Integer> list : graph) Collections.sort(list);

        dfs(start);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(start);

        System.out.println(sb);
    }
    static void dfs(int v){
        visited[v] = true;
        sb.append(v).append(" ");
        for(int next : graph.get(v)){
            if(visited[next]) continue;
            visited[next] = true;
            dfs(next);
        }
    }

    static void bfs(int v){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(v);
        visited[v] = true;
        while(!dq.isEmpty()){
            int current = dq.pollFirst();
            sb.append(current).append(" ");
            for(int next: graph.get(current)) {
                if(visited[next]) continue;
                visited[next] = true;
                dq.addLast(next);
            }
        }
    }
}