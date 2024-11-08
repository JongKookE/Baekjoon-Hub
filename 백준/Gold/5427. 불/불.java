import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static final char EMPTY = '.', WALL = '#', HUMAN = '@', FIRE = '*';
    static final int INF = 987_654_321;
    static int N, col, row;
    static char[][] map;
    static int[][] times;
    static boolean[][] visited;
    static Deque<Node> fireQueue, humanQueue;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map = new char[col][row];
            times = new int[col][row];
            visited = new boolean[col][row];
            fireQueue = new ArrayDeque<>();
            humanQueue = new ArrayDeque<>();
            Arrays.stream(times).forEach(row -> Arrays.fill(row, INF));
            for(int c = 0; c < col; c++){
                String str = br.readLine();
                for(int r = 0; r < row; r++){
                    char ch = str.charAt(r);
                    map[c][r] = ch;
                    if(ch == FIRE) fireQueue.addLast(new Node(c, r, 0));
                    if(ch == HUMAN) humanQueue.addLast(new Node(c, r, 0));
//                    if(ch == EMPTY) times[c][r] = -1;
                }
            }

            escape();
        }
        System.out.println(sb.toString());
    }

    static void escape(){
        while(!fireQueue.isEmpty()){
            Node fire = fireQueue.pollFirst();
            visited[fire.y][fire.x] = true;
            for(int d = 0; d < 4; d++){
                int ny = fire.y + dy[d];
                int nx = fire.x + dx[d];
                if(!isRange(ny, nx) || visited[ny][nx] || map[ny][nx] == WALL) continue;
                visited[ny][nx] = true;
                times[ny][nx] = fire.time+1;
                fireQueue.addLast(new Node(ny, nx, fire.time+1));
            }
        }
        visited = new boolean[col][row];
        while(!humanQueue.isEmpty()){
            Node human = humanQueue.pollFirst();
            visited[human.y][human.x] = true;
            for(int d = 0; d < 4; d++){
                int ny = human.y + dy[d];
                int nx = human.x + dx[d];
                if(!isRange(ny, nx)){
                    sb.append(human.time+1).append("\n");
                    return;
                }
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == WALL) continue;
                if(map[ny][nx] == FIRE) continue;
                if(human.time+1 >= times[ny][nx]) continue;

                visited[ny][nx] = true;
                humanQueue.addLast(new Node(ny, nx, human.time+1));
            }
        }
        sb.append("IMPOSSIBLE").append("\n");
    }
    static boolean isRange(int y, int x){
        return y >= 0 && x >= 0 && y < col && x < row;
    }
    static class Node{
        int y, x, time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", time=" + time +
                    '}';
        }
    }
}

/**
1
10 5
##########
#@....#*.#
#.....#..#
#.....#..#
##.#######
 */