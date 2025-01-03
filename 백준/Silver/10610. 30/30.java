import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        long sum = 0;
        int[] numbers = new int[10];
        for(int i = 0; i < length; i++){
            int value = str.charAt(i) - '0';
            numbers[value]++;
            sum += value;
        }
        if(sum % 3 != 0 || !str.contains("0")){
            System.out.println(-1);
            return;
        }

        for(int i = 9; i >= 0; i--){
            int frequency = numbers[i];
            sb.append(String.valueOf(i).repeat(Math.max(0, frequency)));
        }
        System.out.println(sb);
    }
}