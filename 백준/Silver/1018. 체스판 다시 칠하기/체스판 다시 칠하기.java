import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int col, row, MIN = Integer.MAX_VALUE;
    static final int MINIMUM_SIZE = 8;
    static char[][] walls;
    static final char W = 'W', B = 'B';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        walls = new char[col][row];
        for (int i = 0; i < col; i++) walls[i] = br.readLine().toCharArray();

        for(int i = 0; i < col - MINIMUM_SIZE + 1; i++){
            for(int j = 0; j < row - MINIMUM_SIZE + 1; j++){
                MIN = Math.min(MIN, checkEightByEight(i, j));
            }
        }
        System.out.println(MIN);

    }
    static int checkEightByEight(int col, int row) {
        char currentColor = fillIn(walls[col][row]);
        int result = 0;
        for(int i = col; i < col + MINIMUM_SIZE; i++){
            for(int j = row; j < row + MINIMUM_SIZE; j++){
                if(walls[i][j] == currentColor) result++;
                currentColor = fillIn(currentColor);
            }
            // row의 제일 끝으로 가면 처음에 선정된 색과 다른 색임
            // 그 상태에서 fillIn을 하게되면 최초의 색과 같아짐
            // 위 아래가 동일한 색깔이 되게 되므로 색을 한번 더 바꿔야함
            currentColor = fillIn(currentColor);
        }
        return Math.min(result, 64 - result);
    }

    static char fillIn(char ch){
        return ch == 'W' ? B : W;
    }
}