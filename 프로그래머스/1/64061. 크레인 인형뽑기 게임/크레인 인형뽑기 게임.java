import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static int colLength, rowLength;
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        colLength = board.length;
        rowLength = board[0].length;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int move: moves){
            int kindOfDoll = getLastDoll(board, move);
            if(kindOfDoll == 0) continue;
            if(dq.isEmpty()){
                dq.addLast(kindOfDoll);
                continue;
            }
            if(dq.peekLast() == kindOfDoll){
                dq.pollLast();
                answer+=2;
            }
            else dq.addLast(kindOfDoll);
        }
        return answer;
    }
    static int getLastDoll(int[][] board, int move){
        for(int i = 0; i < colLength; i++){
            int doll = board[i][move-1];
            if(doll == 0) continue;
            board[i][move-1] = 0;
            return doll;
        }
        return 0;
    }
}