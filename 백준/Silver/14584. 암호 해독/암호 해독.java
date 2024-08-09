import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        int cnt = Integer.parseInt(br.readLine());
        String[] words = new String[cnt];
        char[] chars = new char[origin.length()];

        for(int c = 0; c < cnt; c++) words[c] = br.readLine();
        for(int c = 0; c < origin.length(); c++) chars[c] = origin.charAt(c);

        int aToz = 'z' - 'a' + 1;

        for(int c = 0; c < aToz; c++) {
            for(int j = 0; j < origin.length(); j++) {
                char ch = chars[j];
                if (ch == 'Z') ch = 'A';
                else if (ch == 'z') ch = 'a';
                else ch = (char) (ch + 1);
                chars[j] = ch;
            }
            if(isContain(words, chars)){
                for(char ch: chars) System.out.print(ch);
                return;
            }
        }

    }
    static boolean isContain(String[] words, char[] chs){
        String value = String.valueOf(chs);
        for(String str: words){
            if(!value.contains(str)) continue;
            return true;
        }
        return false;
    }
}