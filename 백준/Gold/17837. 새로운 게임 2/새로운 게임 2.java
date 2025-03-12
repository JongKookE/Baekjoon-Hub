import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, K, turn=1, size;
    static final int W = 0, R = 1, B = 2;
    static int[] dy = {0, 0, -1, 1}, dx = {1, -1, 0, 0};
    static int[][] colors;
    static Position[] horsePosition;
    static Deque<Integer> nextDQ, tempDqForMove = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        colors = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(colors));
        horsePosition = new Position[K];
        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken())-1;
            horsePosition[k] = new Position(y, x, dir);
        }

        Deque<Integer>[][] dqArray = make2DimensionDequeArray();

        while(turn <= 1000){
            for(int k = 0; k < K; k++) {
                horsePosition[k].move(k, dqArray);

                for(Position position : horsePosition) {
                    if(dqArray[position.y][position.x].size() < 4) continue;
                    System.out.println(turn);
                    return;
                }
            }
            turn++;
        }
        System.out.println(-1);
    }
    static Deque<Integer>[][] make2DimensionDequeArray(){
        Deque<Integer>[][] dqArray = new ArrayDeque[N][N];
        for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) dqArray[i][j] = new ArrayDeque<>();
        for(int k = 0; k < K; k++){
            int y = horsePosition[k].y;
            int x = horsePosition[k].x;
            dqArray[y][x].add(k);
        }
        return dqArray;
    }

    static class Position{
        int y, x, dir;
        public Position(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        public int nextPositionColor(int ny, int nx, int[][] colors){
            if(ny < 0 || nx < 0 || ny >= N || nx >= N) return B;
            return colors[ny][nx];
        }

        public void move(int number, Deque<Integer>[][] dqArray){
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            int nextColor = nextPositionColor(ny, nx ,colors);
            if(nextColor == B){
                int reversedDir = reversedDir(dir);
                int reverseNextY = y + dy[reversedDir];
                int reverseNextX = x + dx[reversedDir];
                int nnColor = nextPositionColor(reverseNextY, reverseNextX, colors);                
                if(nnColor == B) {
                    horsePosition[number].dir = reversedDir;
                    return;
                }              
                horsePosition[number] = new Position(reverseNextY, reverseNextX, reversedDir);
                movingToStack(number, y, x, reverseNextY, reverseNextX, dqArray, nnColor);
            }
            else movingToStack(number, y, x, ny, nx, dqArray, nextColor);

        }
        public void movingToStack(int number, int y, int x, int ny, int nx, Deque<Integer>[][] dqArray, int color){
            Deque<Integer> currentStack = dqArray[y][x];
            while(!currentStack.isEmpty()){
                int element = currentStack.pollLast();
                int numberDir = horsePosition[element].dir;
                tempDqForMove.addFirst(element);
                horsePosition[element] = new Position(ny, nx, numberDir);
                if(element == number){
                    if(color == W){
                        dqArray[ny][nx].addAll(tempDqForMove);
                        tempDqForMove.clear();
                    }
                    else if(color == R) while(!tempDqForMove.isEmpty()) dqArray[ny][nx].addLast(tempDqForMove.pollLast());
                    return;
                }
            }
            /**
             * 1 2 3 4, 3을 꺼냄
             * 3 4
             */
        }

        public int reversedDir(int dir){
            if(dir % 2 == 0) return dir+1;
            else return dir-1;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "y=" + y +
                    ", x=" + x +
                    ", dir=" + dir +
                    '}';
        }
    }
}