import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int col, row, squareSize, minRectangleSize, maxRectangleSize;
    static int MAX = Integer.MIN_VALUE;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        arr = new int[col+1][row+1];

        for(int c = 1; c <= col; c++){
            char[] chars = br.readLine().toCharArray();
            for(int r = 1; r <= row; r++) arr[c][r] = chars[r-1] - '0';
        }

        squareSize = Math.min(col, row);
        maxRectangleSize = Math.max(col, row);
        while(true){
            if(squareSize == 1){
                System.out.println(1);
                return;
            }
            for(int c = 1; c <= col - squareSize + 1; c++){
                for(int r = 1; r <= row - squareSize + 1; r++){
                    if(!isCurrectSquare(c, r, squareSize-1)) continue;
                    System.out.println(squareSize * squareSize);
                    return;
                }
            }
            squareSize--;
        }
    }
    static boolean isCurrectSquare(int c, int r, int len){
        return arr[c][r] == arr[c][r+len] && arr[c][r+len] == arr[c+len][r] && arr[c+len][r] == arr[c+len][r+len];
    }
}