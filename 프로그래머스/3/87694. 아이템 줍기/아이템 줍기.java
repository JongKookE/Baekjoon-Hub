import java.util.*;
// ⤵️으로 돌렸다고 생각
// 배열의 크기를 두배로 진행해줘야 꺽이는 구간에서 변이 겹치지 않음
class Solution {
    static final int EMPTY=0, NOT_EDGE=1, EDGE=2, CHARACTER=3, ITEM=4;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[51 * 2][51 * 2];
        for(int[] rec: rectangle){
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            mapping(map, x1, y1, x2, y2);
        }
        map[characterX*2][characterY*2] = CHARACTER;
        map[itemX*2][itemY*2] = ITEM;

        return bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
    }
    
    private int bfs(int[][] map, int startX, int startY, int endX, int endY){
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(startX, startY, 2));
        while(!dq.isEmpty()){
            Node node = dq.pollFirst();
            for(int d = 0; d < 4; d++){
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if(map[nx][ny] == ITEM) return node.count/2;
                if(map[nx][ny] != EDGE) continue;
                map[nx][ny] = EMPTY;
                dq.addLast(new Node(nx, ny, node.count+1));
            }
        }
        return -1;
    }
    
    private void mapping(int[][] map, int x1, int y1, int x2, int y2){
        for(int x = x1; x <= x2; x++){
            for(int y = y1; y <= y2; y++){
                if(map[x][y] == NOT_EDGE) continue;
                map[x][y] = NOT_EDGE;
                if(x == x1 || x == x2 || y == y1 || y == y2) map[x][y] = EDGE;
            }
        }
    }
}

class Node{
    int x, y, count;
    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}