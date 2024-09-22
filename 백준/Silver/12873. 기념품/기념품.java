import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(1);
            return;
        }

        ArrayList<Long> participants = new ArrayList<>();
        for(long n = 1; n <= N; n++) participants.add(n);
        int index = 0;

        for(int n = 1; n < N; n++){
            int size = participants.size();
            index = getDivideNumber(n, size, index);
            participants.remove(index);
        }
        System.out.println(participants.get(0));

    }
    static int getDivideNumber (int n, int size, int index){
        long threePow = (long) Math.pow(n, 3);
        return (int)((index + threePow - 1) % size);
    }
}