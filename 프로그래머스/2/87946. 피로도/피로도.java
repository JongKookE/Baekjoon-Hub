class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        answer = Math.max(answer, dfs(k, dungeons, visited, 0));
        return answer;
    }
    int dfs(int k, int[][] dungeons, boolean[] visited, int depth){
        int max = depth;
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i]) continue;
            if(k < dungeons[i][0]) continue;
            visited[i] = true;
            max = Math.max(max, dfs(k - dungeons[i][1], dungeons, visited, depth + 1));
            visited[i] = false;
        }
        return max;
    }
}
