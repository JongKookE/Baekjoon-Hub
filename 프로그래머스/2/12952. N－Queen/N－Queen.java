class Solution {
    public int solution(int n) {
        int[] queens = new int[n];
        return nQueens(n, 0, queens);
    }
    int nQueens(int n, int depth, int[] queens){
        if(depth == n) return 1;

        int count = 0;

        for(int i = 0; i < n; i++){
            queens[depth] = i;
            if(!isPossible(queens, depth)) continue;
            count += nQueens(n, depth+1, queens);
        }

        return count;
    }

    boolean isPossible(int[] queens, int depth){
        for(int i = 0; i < depth; i++){
            if (queens[i] == queens[depth]) return false;
            if (Math.abs(depth - i) == Math.abs(queens[depth] - queens[i])) return false;
        }
        return true;
    }
}
