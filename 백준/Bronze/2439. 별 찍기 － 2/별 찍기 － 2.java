import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String star = "*";
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j < N-i-1) sb.append(" ");
                else sb.append(star);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}