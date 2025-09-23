import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int index = 0; index < N; index++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            nodes[index] = new Node(index, weight, height);
        }
        for(int n = 0; n < N; n++){
            Node current = nodes[n];
            for(int m = 0; m < N; m++){
                if(n == m) continue;
                Node next = nodes[m];
                if(current.height < next.height && current.weight < next.weight) current.rank++;

            }
        }
        for(Node node : nodes) System.out.print(node.rank + " ");

    }
    static class Node{
        int index, weight, height;
        int rank = 1;

        public Node(int index, int weight, int height){
            this.index = index;
            this.weight = weight;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", weight=" + weight +
                    ", height=" + height +
                    ", rank=" + rank +
                    '}';
        }
    }
}