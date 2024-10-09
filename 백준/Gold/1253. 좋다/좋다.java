import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) array[n] = Integer.parseInt(st.nextToken());
        Arrays.sort(array);
        int result = 0;
        for(int n = 0; n < N; n++){
            int target = array[n];
            int start = 0;
            int end = N - 1;
            while(start < end){
                int currentSum = array[start] + array[end];
                if(currentSum == target){
                    if(start != n && end != n){
                        result++;
                        break;
                    }
                    else if(start == n) start++;
                    else end--;
                }
                else if(currentSum > target) end--;
                else start++;
            }
        }
        System.out.println(result);
    }
}