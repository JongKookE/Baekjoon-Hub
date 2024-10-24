import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] floyd;
    static int[] items;
    static int location, search, road;
    static final int INF = 987_654_321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        location = Integer.parseInt(st.nextToken());
        search = Integer.parseInt(st.nextToken());
        road = Integer.parseInt(st.nextToken());

        items = new int[location];
        floyd = new int[location+1][location+1];

        for(int i = 1; i <= location; i++){
            for(int j = 1; j <= location; j++){
                if(i == j) floyd[i][j] = 0;
                else floyd[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < location; i++) items[i] = Integer.parseInt(st.nextToken());
        for(int r = 0; r < road; r++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int meter = Integer.parseInt(st.nextToken());
            floyd[from][to] = Math.min(floyd[from][to], meter);
            floyd[to][from] = Math.min(floyd[to][from], meter);
        }

        for(int mid = 1; mid <= location; mid++) {
            for(int start = 1; start <= location; start++) {
                for(int end = 1; end <= location; end++) {
                    floyd[start][end] = Math.min(floyd[start][end], floyd[start][mid] + floyd[mid][end]);
                }
            }
        }
        System.out.println(getResult());
    }
    static int getResult(){
        int max = 0;
        for(int i = 1; i <= location; i++){
            int sum = 0;
            for(int j = 1; j <= location; j++){
                if(floyd[i][j] <= search) sum += items[j-1];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}