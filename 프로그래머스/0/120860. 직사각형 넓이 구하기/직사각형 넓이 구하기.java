class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int minX = dots[0][0];
        int maxX = dots[0][0];
        int minY = dots[0][1];
        int maxY = dots[0][1];
        
        for(int[] dot: dots){
            minX = Math.min(minX, dot[0]);
            maxX = Math.max(maxX, dot[0]);
            minY = Math.min(minY, dot[1]);
            maxY = Math.max(maxY, dot[1]);
        }
        answer = (maxX - minX) * (maxY - minY);
        return answer;
    }
}