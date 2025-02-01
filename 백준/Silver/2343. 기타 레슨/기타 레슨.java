import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(getMaximumBlueLayTime(arr));
    }
    static int getMaximumBlueLayTime(int[] arr) {
        int start = 0, end = 0;
        for(int v: arr){
            end += v;
            start = Math.max(start, v);
        }
        while(start <= end){
            int sum = 0, count = 0, mid = (start + end)/2;
            for(int v: arr){
                if(sum + v > mid){
                    count++;
                    sum = 0;
                }
                sum += v;
            }
            // sum이 0이 아니라면 블루레이가 더 필요한 상황
            if(sum != 0) count++;
            // 최소 사이즈 +
            if(count > M) start = mid + 1;
            // 최대 사이즈 - 
            else end = mid - 1;
        }
        return start;
    }
}