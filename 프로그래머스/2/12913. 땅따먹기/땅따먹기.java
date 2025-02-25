class Solution {
    int solution(int[][] land) {
            int[][] dp = new int[land.length][4];
            for(int i = 1; i < land.length; i++){
                land[i][0] += compareThreeElement(land[i-1][1], land[i-1][2], land[i-1][3]);
                land[i][1] += compareThreeElement(land[i-1][0], land[i-1][2], land[i-1][3]);
                land[i][2] += compareThreeElement(land[i-1][0], land[i-1][1], land[i-1][3]);
                land[i][3] += compareThreeElement(land[i-1][0], land[i-1][1], land[i-1][2]);
            }
            int answer = 0;
            for(int i = 0; i < 4; i++){
                answer = Math.max(answer, land[land.length-1][i]);
            }
            return answer;
        }
    int compareThreeElement(int one, int two, int three){
        return Math.max(three, Math.max(one, two));
    }
}