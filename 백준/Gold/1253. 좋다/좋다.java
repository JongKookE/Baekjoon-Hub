import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        array = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) array[n]= Long.parseLong(st.nextToken());


        Arrays.sort(array);

        for(int i = 0; i < N; i++){
            long value = array[i];
            int start = 0;
            int end = N-1;
            while(start < end){
                long element = array[start] + array[end];
                if (element == value){
                    if(start != i && end != i){
                        cnt++;
                        break;
                    }
                    else if (start == i) start++;
                    else if (end == i) end--;

                }
                else if (element > value) end--;
                else start++;
            }
        }
        System.out.println(cnt);
    }
}