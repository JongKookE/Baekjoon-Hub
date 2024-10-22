class Solution{
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
    void dfs(int n, int index, int[][] computers, boolean[] visited) {
        int[] computer = computers[index];
        for(int i = 0; i < n; i++){
            if(visited[i] || i == index) continue;
            if(computer[i] == 0) continue;
            visited[i] = true;
            dfs(n, i, computers, visited);
        }
    }
}