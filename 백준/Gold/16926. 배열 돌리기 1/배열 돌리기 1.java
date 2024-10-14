import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int col, row, rotate;
    static int[] dy = {0, 1, 0, -1},
                 dx = {1, 0, -1, 0};
    static int[][] origin;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        rotate = Integer.parseInt(st.nextToken());

        origin = new int[col][row];

        for(int c = 0; c < col; c++) {
            st = new StringTokenizer(br.readLine());
            for(int r = 0; r < row; r++) origin[c][r] = Integer.parseInt(st.nextToken());
        }

        int min = Math.min(col, row)/2;
        for(int m = 0; m < min; m++) {
            // 해당 루프에서 반시계로 돌려야하는 타일의 수
            int tileNumber = 2 * ((col - 2 * m) + (row - 2 * m)) - 4;
            // 반시계로 돌릴 실제 수
            int round = rotate % tileNumber;
//            System.out.printf("원소의 수: %d, 순회의 수: %d\n", tileNumber, round);
            slide(m, round);
        }
        getResult();

    }
    // rc는 row, col이 시작되는 부분, 해당 부분을 round번 반시계로 회전시킴
    private static void slide(int idx, int round){
        while(round-- > 0){
            int y = idx;
            int x = idx;
            int temp = origin[y][x];
            int dir = 0;
            while(dir < 4){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 예외조건을 rotate 시키는 index 기준으로 처리해줘야함
                if(nx < idx || ny < idx || nx >= row - idx || ny >= col - idx){
                    dir++;
                    continue;
                }
                origin[y][x] = origin[ny][nx];
                y = ny;
                x = nx;
            }
            origin[idx+1][idx] = temp;
        }
    }
    private static void getResult(){
        for(int[] array : origin) {
            for(int element : array) sb.append(element).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}