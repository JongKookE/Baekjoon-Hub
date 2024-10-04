import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(toBee(N));
    }
    static int toBee(int n) {
        int result = 0;
        n--;
        while(n > 0){
            result++;
            n -= (result * 6);
        }
        return result+1;
    }
}