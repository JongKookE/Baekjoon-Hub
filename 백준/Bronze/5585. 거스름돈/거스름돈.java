import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] coins = {500, 100, 50, 10, 5, 1};
    static final int PAY = 1_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int result = 0;
        for(int coin: coins){
            while(price <= PAY){
                price += coin;
                result++;
            }
            price -= coin;
            result--;
        }
        System.out.println(result);
    }
}