import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static int N, result;
    static String first;
    static HashMap<Character, Integer> originMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        first = br.readLine();
        int[] alphabet = new int['z' - 'a' + 1];
        for(int i = 0; i < first.length(); i++){
            char ch = first.charAt(i);
            alphabet[ch - 'A']++;
        }

        for(int n = 0; n < N-1; n++){
            String next = br.readLine();
            int nextCount = 0;
            int[] nextAlphabet = alphabet.clone();

            for(int i = 0; i < next.length(); i++){
                int index = next.charAt(i) - 'A';
                if(nextAlphabet[index] == 0) continue;
                nextAlphabet[index]--;
                nextCount++;
            }

            if (next.length() == first.length() && (nextCount == first.length() || nextCount == first.length() - 1)) result++;
            else if (next.length()+1 == first.length() && nextCount == next.length()) result++;
            else if (next.length()-1 == first.length() && nextCount == next.length()-1) result++;

        }
        System.out.println(result);
    }


}