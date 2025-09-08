class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            dfs(n, i, computers, visited);
            answer++;
        }

        return answer;
    }
    void dfs(int n, int i, int[][] computers, boolean[] visited){
        int[] computer = computers[i];
        for(int j = 0; j < n; j++){
            if(computer[j] == 0 || visited[j] || j == i) continue;
            visited[j] = true;
            dfs(n, j, computers, visited);

        }
    }
}