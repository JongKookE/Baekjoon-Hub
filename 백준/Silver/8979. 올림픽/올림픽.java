import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] scores = new int[N][4];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            scores[i][0] = Integer.parseInt(st.nextToken());
            scores[i][1] = Integer.parseInt(st.nextToken());
            scores[i][2] = Integer.parseInt(st.nextToken());
            scores[i][3] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[1] != o2[1]) return o2[1] - o1[1];
            if(o1[2] != o2[2]) return o2[2] - o1[2];
            return o2[3] - o1[3];
        });

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && !isEquals(scores[i], scores[i - 1])) rank = i + 1;
            if (scores[i][0] == K) break;
        }
        System.out.println(rank);
    }
    static boolean isEquals(int[] a, int[] b){
        return a[1] == b[1] && a[2] == b[2] && a[3] == b[3];
    }
}