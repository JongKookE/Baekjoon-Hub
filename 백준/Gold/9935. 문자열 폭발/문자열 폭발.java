import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        String pattern = br.readLine();
        String result = removeExplosion(input, pattern);
        System.out.println(result.isEmpty() ? "FRULA" : result);
    }
    static String removeExplosion(String str, String pattern) {
        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int patternLength = pattern.length();

        for(char c : str.toCharArray()) {
            sb.append(c);
            if(sb.length() >= patternLength && sb.substring(sb.length() - patternLength).equals(pattern))
                sb.delete(sb.length() - patternLength, sb.length());
        }
        return sb.toString();
    }
}
