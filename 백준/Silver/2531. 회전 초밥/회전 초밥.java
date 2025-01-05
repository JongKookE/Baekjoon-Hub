import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int plate, kind, continuous, coupon, max, count;
    static int[] sushi, eaten;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        plate = Integer.parseInt(st.nextToken());
        kind = Integer.parseInt(st.nextToken());
        continuous = Integer.parseInt(st.nextToken());
        coupon = Integer.parseInt(st.nextToken());
        sushi = new int[plate];
        eaten = new int[kind+1];

        for(int p = 0; p < plate; p++) sushi[p] = Integer.parseInt(br.readLine());

        for(int c = 0; c < continuous; c++) if(eaten[sushi[c]]++ == 0) count++;
        max = count;
        if(eaten[coupon] == 0) max++;

        // 제일 처음 값을 제외하고, 그 다음 값을 추가
        for(int p = 1; p < plate; p++) {
            if(--eaten[sushi[p-1]] == 0) count--;
            int next = (p + continuous - 1) % plate;
            if(eaten[sushi[next]]++ == 0) count++;
            int current = count;
            if(eaten[coupon] == 0) current++;
            max = Math.max(current, max);
        }
        System.out.println(max);
    }
}