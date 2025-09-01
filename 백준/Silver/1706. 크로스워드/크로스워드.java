import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        PriorityQueue<String> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        String[] horizonWords = new String[row];
        StringBuilder[] verticalWords = new StringBuilder[col];

        for(int c = 0; c <col; c++) verticalWords[c] = new StringBuilder();
        for(int r = 0; r < row; r++) horizonWords[r] = br.readLine();

        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; r++){
                verticalWords[c].append(horizonWords[r].charAt(c));
            }
        }

        extractWords(pq, horizonWords, String::toString);
        extractWords(pq, verticalWords, StringBuilder::toString);

//        while(!pq.isEmpty()) System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
    static <T> void extractWords(PriorityQueue<String> pq, T[] items, Function<T, String> converter){
        for(T item : items) insertSplitStr(pq, converter.apply(item));
    }

    static void insertSplitStr(PriorityQueue<String> pq, String word){
        String[] splitWord = word.split("#");
        for(String split : splitWord){
            if(split.length() <= 1) continue;
            pq.add(split);
        }
    }
}