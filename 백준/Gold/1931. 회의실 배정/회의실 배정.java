import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt = 1;

    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Room[] rooms = new Room[N];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms[n] = new Room(start, end);
        }
        Arrays.sort(rooms, (r1, r2) -> {
            if(r1.end == r2.end) return r1.start - r2.start;
            return r1.end - r2.end;
        });

        Room room = rooms[0];
        for(int i = 1; i < N; i++){
            Room nextRoom = rooms[i];
            if(room.end <= nextRoom.start){
                cnt++;
                room = nextRoom;
            }
        }
        System.out.println(cnt);

    }
    static class Room{
        int start, end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}