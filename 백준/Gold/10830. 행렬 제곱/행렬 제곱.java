import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long M;
    static final int MOD = 1000;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        long[][] matrix = new long[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) matrix[i][j] = Long.parseLong(st.nextToken());
        }

        matrix = calculate(matrix, M);

        for(long[] row : matrix){
            for(long col : row) sb.append(col % MOD).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static long[][] square(long[][] matrix, long[][] origin){
        long[][] result = new long[N][N];
        for(int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                    result[i][j] += matrix[i][k] * origin[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }

    static long[][] calculate(long[][] matrix, long depth){
        if(depth == 1) return matrix;
        long[][] result = calculate(matrix, depth / 2);
        result = square(result, result);
        // 홀수일 경우 딱 한번 더 계산 해줘야 함
        // resul t와 result 를 행렬 곱을 하면 안되고 result 와 최초 배열을 행렬 곱 해야함
        if(depth % 2 == 1) result = square(result, matrix);
        return result;
    }
}