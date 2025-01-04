import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int r1, c1, r2, c2, max;
    static int[] dy = {0, -1, 0, 1}, dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r2-r1+1][c2-c1+1];
        fill(arr);
        getResult(arr);
    }
    static void fill(int[][] arr){
        int r = 0, c = 0, dir = 0;
        int value = 1, len = 1, count = 0;
        while(!isEnd(arr)){
            // 배열의 범위에 들어왔다면 값을 채움
            if(r1 <= r && r <= r2 && c1 <= c && c <= c2) arr[r-r1][c-c1] = value;
            r += dy[dir];
            c += dx[dir];

            count++;
            // 방향이 위 또는 아래로 전환되면 채워야하는 수가 한개씩 늘어남
            if(count == len){
                if(dir == 1 || dir == 3) len++;
                count = 0;
                dir = (dir+1)%4;
            }
            value++;
        }
        max = value-1;
    }

    static boolean isEnd(int[][] arr){
        return arr[r2-r1][0] != 0 && arr[0][c2-c1] != 0 && arr[r2-r1][c2-c1] != 0 && arr[0][0] != 0;
    }

    static void getResult(int[][] arr){
        StringBuilder sb = new StringBuilder();

        String format = "%" + String.valueOf(max).length() + "s";
        for(int i = 0; i <= r2-r1; i++){
            for(int j = 0; j <= c2-c1; j++){
                sb.append(String.format(format, arr[i][j])).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}