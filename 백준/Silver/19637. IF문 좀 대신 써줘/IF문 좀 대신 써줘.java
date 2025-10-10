import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] names = new String[N];
        int[] powers = new int[N];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            names[n] = st.nextToken();
            powers[n] = Integer.parseInt(st.nextToken());
        }
        for(int m = 0; m < M; m++) sb.append(names[binarySearch(Integer.parseInt(br.readLine()) ,powers)]).append("\n");
        System.out.println(sb);
    }
    static int binarySearch(int pivot, int[] powers){
        int start = 0, end = powers.length-1;
        int result = 0;
        while(start < end){
            int mid = (end + start)/2;
            if(pivot <= powers[mid]) {
                end = mid;
                result = mid;
            }
            else {
                start = mid+1;
                result = mid+1;
            }
        }
        return result;
    }
}