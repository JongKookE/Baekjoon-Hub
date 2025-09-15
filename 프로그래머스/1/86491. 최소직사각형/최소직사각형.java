class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0, maxH = 0;
        for(int[] size : sizes){
            int width = size[0];
            int height = size[1];
            if(width > height){
                maxW = Math.max(maxW, width);
                maxH = Math.max(maxH, height);
            }
            else {
                maxW = Math.max(maxW, height);
                maxH = Math.max(maxH, width);
            }
        }
        return maxW * maxH;
    }
}