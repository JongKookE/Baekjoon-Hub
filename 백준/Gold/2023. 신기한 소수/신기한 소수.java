import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 첫 자리 수는 2, 3, 5, 7만 가능
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }
    static void dfs(int checkingPrimeNumber, int n) {
        if(n == N){
            if(isPrimeNumber(checkingPrimeNumber)) System.out.println(checkingPrimeNumber);
            return;
        }
        for(int i = 1; i < 10; i++){
            if(i % 2 == 0) continue;
            if(isPrimeNumber(checkingPrimeNumber * 10 + i)) dfs(checkingPrimeNumber * 10 + i, n+1);
        }
    }
    static boolean isPrimeNumber(int n){
        for(int i = 2; i <= Math.sqrt(n); i++) if(n % i == 0) return false;
        return true;
    }
}