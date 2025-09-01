import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Arrays;

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
        visited = new boolean[row][col];
        int answer = 0;
        for(int r = 0; r < row; r++){
            String map = maps[r];
            for(int c = 0; c < col; c++){
                char ch = map.charAt(c);
                chMaps[r][c] = ch;
                if(ch == street || ch == wall) continue;
                position.put(ch, new Node(r, c, 0));
            }
        }
        int findLeverTime = findLever();
        if(findLeverTime == -1) return findLeverTime;
        int findExitTime = findExit(findLeverTime);
        return findExitTime;
    }

    boolean isOverMapRange(int y, int x){
        return y < 0 || x < 0 || y >= row || x >= col;
    }


    int findLever(){
        dq = new ArrayDeque<>();
        Node startNode = position.get(start);
        dq.addLast(startNode);
        while(!dq.isEmpty()){
            Node node = dq.pollFirst();    
            for(int d = 0; d < 4; d++){
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if(isOverMapRange(ny, nx) || visited[ny][nx]) continue;
                char element = chMaps[ny][nx];
                if(element == wall) continue;
                if(element == lever) return node.time+1;
                visited[ny][nx] = true;
                dq.addLast(new Node(ny, nx, node.time+1));
            }
        }
        return -1;
    }

    int findExit(int leverTime){
        dq.clear();
        for(boolean[] visit : visited) Arrays.fill(visit, false);
        Node startNode = position.get(lever);
        visited[startNode.y][startNode.x] = true;
        startNode.time = leverTime;
        dq.addLast(startNode);
        while(!dq.isEmpty()){
            Node node = dq.pollFirst();
            for(int d = 0; d < 4; d++){
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if(isOverMapRange(ny, nx) || visited[ny][nx]) continue;
                char element = chMaps[ny][nx];
                if(element == wall) continue;
                if(element == exit) return node.time+1;
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