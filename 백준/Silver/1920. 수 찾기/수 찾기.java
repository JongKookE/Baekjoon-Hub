import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dataSize = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dataArray = new int[dataSize];
        for(int i = 0; i < dataSize; i++) dataArray[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(dataArray);
        int findSize = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int f = 0; f < findSize; f++){
            int find = Integer.parseInt(st.nextToken());
            System.out.println(search(find, dataArray));
        }
    }
    static int search(int find, int[] dataArray){
        int start = 0, end = dataArray.length-1, mid = 0;
        while(true){
            if(dataArray[mid] == find) return 1;
            if(start > end) break;
            mid = (start + end)/2;
            if(dataArray[mid] > find) end = mid-1;
            else start = mid+1;
        }
        return 0;
    }
}