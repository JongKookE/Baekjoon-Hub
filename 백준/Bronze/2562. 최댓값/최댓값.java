import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int NUMBER_SIZE = 9;
    static int index;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int value = Integer.parseInt(br.readLine());
            if(max > value) continue;
            max = value;
            index = i+1;
        }
        System.out.println(max);
        System.out.println(index);
    }
}