import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] maps;
    // 가로, 대각, 세로
    static int[] dx = {1, 1, 0}, dy = {0, 1, 1};
    static final int HORIZONTAL = 0, DIAGONAL = 1, VERTICAL = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시작점이 0, 1
        // 방향은 가로로 시작함
        pipeline(new Pipe(0, 1, 0));

        System.out.println(result);
    }
    static void pipeline(Pipe pipe){
        int y = pipe.y;
        int x = pipe.x;
        int dir = pipe.dir;
        if(y == N - 1 && x == N - 1){
            result++;
            return;
        }

        for(int d = 0; d < 3; d++){
            // 가로일때 세로는 안됌, 세로일때 가로는 안됌
            if((dir == HORIZONTAL && d == VERTICAL) || (dir == VERTICAL && d == HORIZONTAL)) continue;
            Pipe nextPipe = pipe.going(d);
            if(isRange(nextPipe)) continue;
            if(d == DIAGONAL && (maps[nextPipe.y - 1][nextPipe.x] == 1 || maps[nextPipe.y][nextPipe.x - 1] == 1)) continue;
            pipeline(nextPipe);
        }
    }

    static boolean isRange(Pipe pipe){
        return (pipe.x < 0 || pipe.x >= N || pipe.y < 0 || pipe.y >= N || maps[pipe.y][pipe.x] == 1);
    }

    static class Pipe{
        int y, x, dir;

        public Pipe(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
//            this.cnt = 0;
        }

        Pipe going(int dir){
            return new Pipe(this.y + dy[dir], x + dx[dir], dir);
        }

        @Override
        public String toString() {
            return "Pipe{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dir=" + dir +
                    '}';
        }
    }
}