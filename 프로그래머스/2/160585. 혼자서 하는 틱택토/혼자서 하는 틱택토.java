import java.util.*;


class Solution {
        public int solution(String[] board) {
            int oCount = 0;
            int xCount = 0;

            for(String str : board){
                if(str.charAt(0) == 'O') oCount++;
                if(str.charAt(1) == 'O') oCount++;
                if(str.charAt(2) == 'O') oCount++;
                if(str.charAt(0) == 'X') xCount++;
                if(str.charAt(1) == 'X') xCount++;
                if(str.charAt(2) == 'X') xCount++;
            }


            int oBingo = bingoCount('O', board);
            int xBingo = bingoCount('X', board);

            if (!(oCount == xCount || oCount == xCount + 1)) return 0;
            if (oBingo > 0 && xBingo > 0) return 0;
            if (oBingo > 0 && oCount != xCount + 1) return 0;
            if (xBingo > 0 && oCount != xCount) return 0;
            return 1;
        }

        int bingoCount(char ch, String[] board){
            int count = 0;
            // 세로
            for(int i = 0; i < 3; i++){
                if(board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) count++;
            }
            // 가로
            for(int i = 0; i < 3; i++){
                if(board[i].charAt(0) == ch && board[i].charAt(1) == ch && board[i].charAt(2) == ch) count++;
            }

            // 대각선 2줄
            if (board[0].charAt(0) == ch &&
                    board[1].charAt(1) == ch &&
                    board[2].charAt(2) == ch) {
                count++;
            }

            if (board[0].charAt(2) == ch &&
                    board[1].charAt(1) == ch &&
                    board[2].charAt(0) == ch) {
                count++;
            }

            return count;
        }
}