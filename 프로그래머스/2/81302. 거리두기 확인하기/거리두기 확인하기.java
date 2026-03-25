import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class Solution{
    int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    final int row = 5, col = 5;
    int[] solution(String[][] places){
        int[] answer = new int[5];
        for(int t = 0; t < 5; t++){
            char[][] waitingRooms = buildWaitingRoom(places[t]);
            ArrayList<Node> list = buildParticipantList(waitingRooms);
            answer[t] = bfs(list, waitingRooms);
        }
        return answer;
    }

    int bfs(ArrayList<Node> list, char[][] waitingRooms){
        for (Node node : list) {
            Deque<Node> dq = new ArrayDeque<>();
            boolean[][] visited = new boolean[5][5];
            dq.addLast(node);
            visited[node.r][node.c] = true;
            while (!dq.isEmpty()) {
                Node current = dq.pollFirst();
                if (current.time == 2) continue;
                for (int d = 0; d < 4; d++) {
                    int nr = current.r + dr[d];
                    int nc = current.c + dc[d];

                    if(!isAvailablePlace(nr, nc, waitingRooms, visited)) continue;
                    if(waitingRooms[nr][nc] == 'P') return 0;

                    visited[nr][nc] = true;
                    dq.addLast(new Node(nr, nc, current.time + 1));
                }
            }
        }
        return 1;
    }

    ArrayList<Node> buildParticipantList(char[][] waitingRoom){
        ArrayList<Node> list = new ArrayList<>();

        for(int r = 0; r < 5; r++){
            for(int c = 0; c < 5; c++){
                if(waitingRoom[r][c] == 'P')
                    list.add(new Node(r, c, 0));
            }
        }

        return list;
    }

    boolean isAvailablePlace(int r, int c, char[][] waitingRoom, boolean[][] visited){
        return r >= 0 && c >= 0 && r < row && c < col && waitingRoom[r][c] != 'X' && !visited[r][c];
    }

    char[][] buildWaitingRoom(String[] place){
        char[][] waitingRoom = new char[5][5];
        for(int i = 0; i < 5; i++) waitingRoom[i] = place[i].toCharArray();
        return waitingRoom;
    }

    class Node{
        int r, c, time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", time=" + time +
                    '}';
        }
    }

}
