import java.io.*;
import java.util.*;

public class Main {
    static char[][] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            chars = new char[3][3];
            int xCount = 0;
            int oCount = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    chars[i][j] = str.charAt(i * 3 + j);
                    if(chars[i][j] == 'X') xCount++;
                    if(chars[i][j] == 'O') oCount++;
                }
            }

            if (xCount == oCount + 1) {
                if (xCount + oCount == 9 && !isBingo('O')) sb.append("valid").append("\n");
                 else if (!isBingo('O') && isBingo('X')) sb.append("valid").append("\n");
                 else sb.append("invalid").append("\n");

            } else if (xCount == oCount) {
                if (!isBingo('X') && isBingo('O')) sb.append("valid").append("\n");
                 else sb.append("invalid").append("\n");
            }
            else sb.append("invalid").append("\n");

        }
        System.out.println(sb);
    }

    public static boolean isBingo(char c) {

        for (int i = 0; i < 3; i++) {
            if (chars[i][0] == c && chars[i][1] == c && chars[i][2] == c) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (chars[0][i] == c && chars[1][i] == c && chars[2][i] == c) {
                return true;
            }
        }
        // 대각선
        if (chars[0][0] == c && chars[1][1] == c && chars[2][2] == c) {
            return true;
        }
        // 대각선
        if (chars[0][2] == c && chars[1][1] == c && chars[2][0] == c) {
            return true;
        }

        return false;
    }
}
