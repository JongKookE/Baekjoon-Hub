import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long max = Math.max(x, y);
        long min = Math.min(x, y);

        long distance = x + y;
        long result = 0;
        // 대각선이 직선의 2배보다 크기 때문에 대각선을 사용하지 않는 경우
        if(2 * w <= s) result = (x + y) * w;
        // 대각선이 직선보다 클때
        else if (s > w) result = min * s + (max - min) * w;
        else result = min * s + ((max - min) % 2) * w + ((max - min)/2) * 2 * s;
        System.out.println(result);
    }
}