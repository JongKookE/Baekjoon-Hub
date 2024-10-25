import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int col, row, T;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static Node upper, lower;
    static int[] upperDx = {0, 1, 0, -1}, upperDy = {-1, 0, 1, 0};
    static int[] lowerDx = {0, 1, 0, -1}, lowerDy = {1, 0, -1, 0};
    static int[][] room;
    static final int SPREAD_SIZE = 5, CLEANER = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[col][row];

        for(int c = 0; c < col; c++){
            st = new StringTokenizer(br.readLine());
            for(int r = 0; r < row; r++){
                room[c][r] = Integer.parseInt(st.nextToken());
                if(room[c][r] == CLEANER){
                    if(upper == null) upper = new Node(c, r);
                    else lower = new Node(c, r);
                }
            }
        }


        for(int t = 0; t < T; t++){
            int[][] spreadRoom = spread();
            room = clean(spreadRoom);
        }
        System.out.println(remain(room));
    }

    static int[][] spread(){
        int[][] dust = copyArray();
        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; r++){
                if(room[c][r] <= 0) continue;
                step(dust, c, r);
            }
        }
        return dust;
    }

    static int[][] clean(int[][] spreadRoom){
        // 위, 오른쪽, 아래, 왼쪽
        rotate(spreadRoom, upperDy, upperDx, upper);
        rotate(spreadRoom, lowerDy, lowerDx, lower);
        return spreadRoom;
    }

    static void rotate(int[][] spreadRoom, int[] dy, int[] dx, Node cleaner){
        int dir = 0;
        int x = cleaner.x;
        int y = cleaner.y;

        while(dir < 4){
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(check(ny, nx, cleaner)) {
                dir++;
                continue;
            }
            if(spreadRoom[ny][nx] == CLEANER) {
                spreadRoom[y][x] = 0;
                return;
            }

            if(y == cleaner.y && x == cleaner.x) spreadRoom[ny][nx] = 0;
            else spreadRoom[y][x] = spreadRoom[ny][nx];
            y = ny;
            x = nx;
        }
    }
    static boolean check(int ny, int nx, Node cleaner){
        int y = cleaner.y;
        int x = cleaner.x;
        if(y == upper.y && x == upper.x)
            return (nx < 0 || ny < 0 || ny >= col || nx >= row || ny > y );
        else
            return (nx < 0 || ny < 0 || ny >= col || nx >= row || ny < y);
    }

    static int[][] copyArray(){
        int[][] newArray = new int[col][row];
        for(int c = 0; c < col; c++)
            for(int r = 0; r < row; r++){
                newArray[c][r] = room[c][r];
            }

        return newArray;
    }
    static void step(int[][] dust, int y, int x){
        ArrayList<Node> canSpreadSpot = new ArrayList<>();
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || ny >= col || nx < 0 || nx  >= row || dust[ny][nx] == CLEANER) continue;
            canSpreadSpot.add(new Node(ny, nx));
        }
        for(Node node: canSpreadSpot) dust[node.y][node.x] += (room[y][x]/SPREAD_SIZE);
        dust[y][x] -= ((room[y][x]/SPREAD_SIZE) * canSpreadSpot.size());
    }

    static int remain(int[][] dust){
        return Arrays.stream(dust)
                .flatMapToInt(Arrays::stream)
                .filter(d -> d != -1)
                .sum();
    }

    static void print(int[][] dust){
        for(int[] dustRow : dust){
            for(int d: dustRow) System.out.print(d + " ");
            System.out.println();
        }
        System.out.println();
    }

    static class Node{
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}