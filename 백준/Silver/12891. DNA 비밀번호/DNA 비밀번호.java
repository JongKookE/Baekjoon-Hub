import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String dnaWord;
    static int[] arr;
    static final int DNA_KIND = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dnaWord = br.readLine();
        int size = dnaWord.length();
        arr = new int[DNA_KIND];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < DNA_KIND; i++) arr[i] = Integer.parseInt(st.nextToken());
        int result = 0;
        int start = 0, end = M;

        for(int i = 0; i < M; i++){
            char ch = dnaWord.charAt(i);
            arr[checkDna(ch)]--;
        }

        if(isDnaPassword(arr)) result++;

        while(end < size){
            char add = dnaWord.charAt(end++);
            char remove = dnaWord.charAt(start++);
            arr[checkDna(add)]--;
            arr[checkDna(remove)]++;
            if(isDnaPassword(arr)) result++;
        }

        System.out.println(result);
    }

    static private int checkDna(char ch){
        return switch (ch) {
            case 'A' -> 0;
            case 'C' -> 1;
            case 'G' -> 2;
//            case 'T' -> 3;
            default -> 3;
        };
    }
    static private boolean isDnaPassword(int[] arr){
        for(int num: arr){
            if(num <= 0) continue;
            return false;
        }
        return true;
    }

}