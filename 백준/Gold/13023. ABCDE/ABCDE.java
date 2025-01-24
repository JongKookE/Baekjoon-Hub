import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int node, edge;
    static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        for(int n = 0; n < node; n++) friends.add(new ArrayList<>());

        for(int e = 0; e < edge; e++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            friends.get(from).add(to);
            friends.get(to).add(from);
        }

        for(int i = 0; i < node; i++){
            visited = new boolean[node];
            findFriends(i, 1);
            if(flag) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }
    static void findFriends(int start, int depth){
        if(depth == 5){
            flag = true;
            return;
        }
        visited[start] = true;
        for(int friend: friends.get(start)){
            if(visited[friend]) continue;
            visited[start] = true;
            findFriends(friend, depth+1);
            visited[friend] = false;
        }
    }
}