import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        int[] values = new int[26];

        for(int n = 0; n < N; n++){
            String word = br.readLine();
            words[n] = word;
            for(int j = 0; j < word.length(); j++) values[word.charAt(j) - 'A'] += (int) Math.pow(10, word.length() - j - 1);
        }
        Arrays.sort(values);
        int sum = 0;
        int startValue = 9;

        for(int i = 25; i >= 0; i--) {
            int value = values[i];
            if(value == 0) break;
            sum += (value * startValue);
            startValue--;
        }


        System.out.println(sum);
    }
}
