import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    int row, col;
    boolean[][] visited;
    char[][] map;
    int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    public int solution(String[] board) {
        row = board.length;
        col = board[0].length();
        visited = new boolean[row][col];
        map = new char[row][col];
        Node start = null, destination = null;
        for(int r = 0; r < row; r++){
            String str = board[r];
            for(int c = 0; c < col; c++){
                char ch = str.charAt(c);
                if(ch == 'R') start = new Node(r, c);
                if(ch == 'G') destination = new Node(r, c);
                map[r][c] = ch;
            }
        }

        return bfs(start, destination);
    }
    boolean isRange(int y, int x){
        return y >= 0 && x >= 0 && y < row && x < col && map[y][x] != 'D';
    }
    int bfs(Node start, Node destination){
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(start);
        visited[start.y][start.x] = true;

        while(!dq.isEmpty()){
            Node node = dq.pollFirst();
            for(int d = 0; d < 4; d++){
                int ny = node.y;
                int nx = node.x;
                while(isRange(ny, nx)){
                    ny += dy[d];
                    nx += dx[d];
                }
                ny -= dy[d];
                nx -= dx[d];
                if(destination.y == ny && destination.x == nx) return node.time+1;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                dq.add(new Node(ny, nx, node.time + 1));
            }
        }
        return -1;
    }
    class Node{
        int y, x, time;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
        public Node(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}