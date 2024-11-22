import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, totalDistance;
    static int[] dy = {-1, 0, 0, 1}, dx = {0, -1, 1, 0};
    static int[][] map, distance;
    static boolean[][] visited;
    static Shark babyShark;
    static int BABYSHARK = 9, EMPTY = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        distance = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != BABYSHARK) continue;
                babyShark = new Shark(new Position(i, j, 0), 2, 0);
                map[i][j] = 0;
            }
        }

        while(true){
            Position nextFishPosition = findNextFish(babyShark);
            if(nextFishPosition == null) break;
            totalDistance += nextFishPosition.dist;
            babyShark.pos.move(nextFishPosition);

        }
        System.out.println(totalDistance);
    }

    static Position findNextFish(Shark shark){
        PriorityQueue<Position> pq = new PriorityQueue<>();
        Position start = shark.pos;
        pq.add(start);
        map[start.y][start.x] = 0;
        visited = new boolean[N][N];
        visited[start.y][start.x] = true;
        Position nextFish = null;
        while(!pq.isEmpty()){
            Position pos = pq.poll();
            int currY = pos.y;
            int currX = pos.x;
            if (shark.canEat(map[currY][currX])) {
                if (nextFish == null || pos.compareTo(nextFish) < 0) nextFish = pos; // 우선순위가 더 높은 생선을 선택
                continue; // 우선순위에 따라 더 가까운 생선을 찾기 위해 계속 탐색
            }
//            System.out.println("BFS method");
            for(int d = 0; d < 4; d++){
                int ny = dy[d] + currY;
                int nx = dx[d] + currX;
                if(!isInRange(ny, nx) || visited[ny][nx] || !shark.canMove(map[ny][nx])) continue;
                visited[ny][nx] = true;
                pq.add(new Position(ny, nx, pos.dist+1));
                distance[ny][nx] = distance[currY][currX] + 1;
                // 상어가 다음 위치에서 생선을 먹지 못하면 for문 순회

            }
        }
        if (nextFish != null) {
            shark.eat(); // 상어가 생선을 먹음
            map[nextFish.y][nextFish.x] = 0; // 해당 위치를 비움
        }
        return nextFish;
    }

    static boolean isInRange(int y, int x){
        return y >= 0 && x >= 0 && y < N && x < N;
    }

    static class Position implements Comparable<Position>{
        int y, x, dist;

        Position(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        void move(Position p){
            this.y = p.y;
            this.x = p.x;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }

        @Override
        public int compareTo(Position other) {
            if (this.dist != other.dist) {
                return Integer.compare(this.dist, other.dist);
            }

            // 두 번째 우선순위: y 좌표 (위쪽)
            if (this.y != other.y) {
                return Integer.compare(this.y, other.y);
            }

            // 세 번째 우선순위: x 좌표 (왼쪽)
            return Integer.compare(this.x, other.x);
        }
    }

    static class Shark{
        Position pos;
        int size, eatenFish;

        public Shark(Position pos, int size, int eatenFish) {
            this.pos = pos;
            this.size = size;
            this.eatenFish = eatenFish;
        }

        void eat() {
            eatenFish++;
            if (eatenFish == size) {
                size++;
                eatenFish = 0;
            }
        }

        boolean canEat(int fishSize) {
            return fishSize > 0 && fishSize < size;
        }

        boolean canMove(int fishSize) {
            return fishSize <= size;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "pos=" + pos +
                    ", size=" + size +
                    ", eatenFish=" + eatenFish +
                    '}';
        }
    }
}