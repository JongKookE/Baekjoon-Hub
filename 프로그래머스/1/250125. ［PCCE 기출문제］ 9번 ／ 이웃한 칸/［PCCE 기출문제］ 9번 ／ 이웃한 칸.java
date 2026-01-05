class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 0, 1, -1};
        int[] dw = {1, -1, 0, 0};
        int boardLength = board.length;
        for(int i = 0; i < 4; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];
            // System.out.printf("%d, %d\n", nh, nw);
            if(nh < 0 || nw < 0 || nh >= boardLength || nw >= boardLength) continue;
            // System.out.printf("%s, %s\n", board[h][w], board[nh][nw]);
            if(!board[h][w].equals(board[nh][nw])) continue;
            answer++;
        }
        return answer;
    }
}