import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] channels = new String[N];
        String kbs1 = "KBS1";
        String kbs2 = "KBS2";
        int kbs1Index = 0;
        int kbs2Index = 0;
        for(int n = 0; n < N; n++){
            String str = br.readLine();
            if(str.equals(kbs1)) kbs1Index = n;
            if(str.equals(kbs2)) kbs2Index = n;
            channels[n] = str;
        }
        sb.append("1".repeat(kbs1Index));
        sb.append("4".repeat(kbs1Index));

        if(kbs1Index > kbs2Index) {
            sb.append("1".repeat(kbs2Index+1));
            sb.append("4".repeat(kbs2Index));
        }
        else {
            sb.append("1".repeat(kbs2Index));
            sb.append("4".repeat(kbs2Index-1));
        }


        System.out.println(sb);
    }
}
