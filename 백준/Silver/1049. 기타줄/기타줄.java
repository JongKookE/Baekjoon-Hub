import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, six = Integer.MAX_VALUE, single = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            six = Math.min(six, Integer.parseInt(st.nextToken()));
            single = Math.min(single, Integer.parseInt(st.nextToken()));
        }

        // 언제나 single을 선택하는게 좋을 경우
        if(single * 6 <= six )System.out.println(single * N);
        else{
            int quotient = N / 6;
            int remain = N % 6;
            System.out.println(quotient * six + Math.min(remain * single, six));
        }
    }
}