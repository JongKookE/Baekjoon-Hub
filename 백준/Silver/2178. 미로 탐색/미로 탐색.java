import java.io.*;
import java.util.*;

public class Main {
    static int col, row, map[][];
    static char[][] chars;
    static int[] dx = {-1,1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[col][row];

        visited = new boolean[col][row];

        for(int c = 0; c < col; c++){
            char[] chs = br.readLine().toCharArray();
            for(int r = 0; r < row; r++){
                map[c][r] = chs[r] - '0';
            }
        }
        bfs();
        System.out.println(map[col-1][row-1]);
    }
    static void bfs(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0));
        while(!queue.isEmpty()){
            Node current = queue.poll();       
            for(int d = 0; d < 4; d++){
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                if(nx < 0 || ny < 0 || nx >= col || ny >= row) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                map[nx][ny] = map[current.x][current.y] + 1;
                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;

            }
        }

    }
    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}