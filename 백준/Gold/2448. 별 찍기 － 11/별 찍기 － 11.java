import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[][] stars;
    static boolean[][] visited;
    static int n, row;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        row = (n << 1);
        stars = new char[n][row];
        visited = new boolean[n][row];
        makeStar(0, row/2-1, n);
        for(char[] chr: stars){
            for(char ch: chr){
                if(ch == '*') sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
//        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
//        System.out.println(stars[n-1].length);
    }
    static void makeStar(int y, int x, int depth) {
        if(depth == 3) {
            stars[y][x] = '*';
            stars[y + 1][x - 1] = '*';
            stars[y + 1][x + 1] = '*';
            for (int s = x - 2; s <= x + 2; s++) stars[y + 2][s] = '*';
            return;
        }
        makeStar(y, x, depth/2);
        makeStar(y + depth/2, x - depth/2, depth/2);
        makeStar(y+depth/2, x + depth/2, depth/2);
    }

}