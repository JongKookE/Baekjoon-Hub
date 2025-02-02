import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int[] arr = new int[2];
        char current = chars[0];
        arr[current - '0'] += 1;
        for(int i = 1; i < chars.length; i++) {
            char next = chars[i];
            if(current == next) continue;
            arr[next - '0'] += 1;
            current = next;
        }
        System.out.println(Math.min(arr[0], arr[1]));
    }
}