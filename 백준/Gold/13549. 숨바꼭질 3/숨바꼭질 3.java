import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100_000;
    static int subin, brother;
    static int[] visited;
    static Deque<Node> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());
        visited = new int[MAX+1];
        visited[subin] = 1;
        hideAndSeek();
        System.out.println(visited[brother]-1);
    }

    static void hideAndSeek() {
        deque.addLast(new Node(subin, 1));
        while(!deque.isEmpty()){
            Node node = deque.pollFirst();
            if(node.loc > MAX) continue;
            teleport(node);
            moveForward(node);
            moveBackward(node);
        }
    }

    static void moveForward(Node node){
        if(node.loc+1 > MAX) return;
        if(visited[node.loc+1] == 0 || visited[node.loc+1] > node.time+1) {
            visited[node.loc + 1] = node.time + 1;
            deque.addLast(new Node(node.loc + 1, node.time + 1));
        }
    }

    static void moveBackward(Node node){
        if(node.loc-1 < 0) return;
        if(visited[node.loc-1] == 0 || visited[node.loc-1] > node.time+1) {
            visited[node.loc - 1] = node.time + 1;
            deque.addLast(new Node(node.loc - 1, node.time + 1));
        }
    }

    static void teleport(Node node){
        if(node.loc*2 > MAX) return;
        if(visited[node.loc*2] == 0 || visited[node.loc*2] > node.time) {
            visited[node.loc * 2] = node.time;
            deque.addLast(new Node(node.loc * 2, node.time));
        }
    }

    static class Node{
        int loc, time;

        public Node(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }
}