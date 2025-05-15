import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxValue = Integer.MIN_VALUE;
    static int col, row;
    static int[][] numbers;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        numbers = new int[col][row];
        visited = new boolean[col][row];

        for(int c = 0; c < col; c++){
            st = new StringTokenizer(br.readLine());
            for(int r = 0; r < row; r++){
                numbers[c][r] = Integer.parseInt(st.nextToken());
            }
        }

        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; r++){
                visited[c][r] = true;
                recursive(c, r, 1, numbers[c][r]);
                visited[c][r] = false;
            }
        }
        System.out.println(maxValue);

    }
    static void recursive(int y, int x, int depth, int sum){
        if(depth == 4){
            maxValue = Math.max(maxValue, sum);
            return;
        }

        for(int d = 0; d < 4; d++){
            int ny = dy[d] + y;
            int nx = dx[d] + x;
            if(!isRange(ny, nx)) continue;

            int value = numbers[ny][nx];

            if(depth == 2){
                visited[ny][nx] = true;
                recursive(y, x, depth+1, sum+value);
                visited[ny][nx] = false;
            }
            visited[ny][nx] = true;
            recursive(ny, nx, depth+1, sum+value);
            visited[ny][nx] = false;
        }
    }
    // 범위 안이면서 방문한 적이 없다면 true;
    static boolean isRange(int y, int x){
        return (y >= 0 && x >= 0 && y < col && x < row && !visited[y][x]);
    }
}
