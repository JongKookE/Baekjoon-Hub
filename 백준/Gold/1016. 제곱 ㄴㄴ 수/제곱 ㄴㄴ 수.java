import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long min, max, count;
    static boolean[] isNotPrimes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = Long.parseLong(st.nextToken());
        max = Long.parseLong(st.nextToken());
        isNotPrimes = new boolean[(int) (max - min + 1)];
        for(long i = 2; i * i <= max; i++){
            long pow = i * i;
            long startIndex = min / pow;
            // 나머지가 0이라면 제곱을 해도 min 보다 작은 값이 나오기 때문에 index++을 해야함
            if(min % pow != 0) startIndex++;
            for(long j = startIndex; pow * j <= max; j++){
                int nextIndex = (int) (pow * j - min);
                // 소수라면 다음 반복문
                if(isNotPrimes[nextIndex]) continue;
                isNotPrimes[nextIndex] = true;
                count--;
            }
        }
        System.out.println(max - min + 1 + count);
    }
}