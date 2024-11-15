import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int numberOfPlants = Integer.parseInt(br.readLine());
            int result = 0;
            while(numberOfPlants-- > 0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                boolean sPosition = containsPlants(sx, sy, x, y, r);
                boolean ePosition = containsPlants(ex, ey, x, y, r);
                if((sPosition && ePosition) || (!sPosition && !ePosition)) continue;
                result++;
            }
            System.out.println(result);
        }
    }
    static boolean containsPlants(int sx, int sy, int x, int y, int r){
        return Math.sqrt(Math.pow(sx - x, 2) + Math.pow(sy - y, 2)) < r;
    }
}