import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int c, r, d;
    // 북, 동, 남, 서
    static int[] dc = {-1, 0, 1, 0}, dr = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] cleaned;
    static final int NOWHERE = 4, WALL = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cleaned = new boolean[N][M];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++){
                int value = Integer.parseInt(st.nextToken());
                map[n][m] = value;
            }
        }

        while(true){
            if(!cleaned[c][r]) {
                answer++;
                cleaned[c][r] = true;
            }
            int nextDirection = findUnCleanRoom(c, r);
            if(nextDirection != NOWHERE) {
                d = nextDirection;
                c += dc[d];
                r += dr[d];
                continue;
            }
            int backDirection = (d + 2) % 4;
            int nc = c + dc[backDirection];
            int nr = r + dr[backDirection];

            if(map[nc][nr] == WALL) break;
            c = nc;
            r = nr;

        }
        System.out.println(answer);

    }

    static int findUnCleanRoom(int c, int r){
        for (int i = 0; i < 4; i++) {
            int nextDir = (d + 3 - i) % 4;
            int nc = c + dc[nextDir];
            int nr = r + dr[nextDir];
            if (map[nc][nr] == WALL || cleaned[nc][nr]) continue;
            return nextDir;

        }
        return NOWHERE;
    }
}

/**
 * 북 - 0, 서 - 1, 남 - 2, 동 -3
 * 북 -> 남 | 0 -> 2
 * 동 -> 서 | 3 -> 1
 * (d + 2) % 3
 * 3 + 2 % 3 = 4
 */