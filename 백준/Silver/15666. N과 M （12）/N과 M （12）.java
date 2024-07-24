import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, src;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        src = new int[M];
        dupComb(0,0);
        for (String s : set) System.out.println(s);
    }
    static void dupComb(int start, int idx) {
        if(idx == M){
            set.add(elementToString(src));
            sb.setLength(0);
            return;
        }
        for(int i = start; i < arr.length; i++){
            src[idx] = arr[i];
            dupComb(i,idx+1);
        }
    }

    static String elementToString(int[] arr){
        for (int j : arr) sb.append(j).append(" ");
        return sb.toString();
    }
}