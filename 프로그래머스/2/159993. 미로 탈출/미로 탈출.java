import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {
    int row, col;
    int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    char start = 'S', exit = 'E', lever = 'L', street = 'O', wall = 'X';
    HashMap<Character, Node> position = new HashMap<>();
    Deque<Node> dq;
    char[][] chMaps;
    boolean[][] visited;
    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        chMaps = new char[row][col];
        for(int r = 0; r < row; r++){
            String map = maps[r];
            for(int c = 0; c < col; c++){
                char ch = map.charAt(c);
                chMaps[r][c] = ch;
                if(ch == street || ch == wall) continue;
                position.put(ch, new Node(r, c, 0));
            }
        }
        int findLeverTime = bfs(start, lever, 0);
        if(findLeverTime == -1) return findLeverTime;
        return bfs(lever, exit, findLeverTime);
    }

    boolean isOverMapRange(int y, int x){
        return y < 0 || x < 0 || y >= row || x >= col;
    }


    int bfs(char startingPoint, char destination, int time){
        dq = new ArrayDeque<>();
        visited = new boolean[row][col];
        Node startNode = position.get(startingPoint);
        startNode.time = time;
        visited[startNode.y][startNode.x] = true;
        dq.addLast(startNode);
        while(!dq.isEmpty()){
            Node node = dq.pollFirst();
            for(int d = 0; d < 4; d++){
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if(isOverMapRange(ny, nx) || visited[ny][nx]) continue;
                char element = chMaps[ny][nx];
                if(element == wall) continue;
                if(element == destination) return node.time+1;
                visited[ny][nx] = true;
                dq.addLast(new Node(ny, nx, node.time+1));
            }
        }
        return -1;
    }

    class Node{
        int y, x, time;
        public Node(int y, int x, int time){
            this.y = y;
            this.x = x;
            this.time = time;
        }
        @Override
        public String toString(){
            return String.format("(%d, %d, %d) ", this.y, this.x, this.time);
        }
    }
}