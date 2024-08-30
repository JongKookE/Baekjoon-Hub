import java.util.*;
class Solution {
        public int solution(int[][] triangle) {
            int size = triangle.length;
            for(int i = size-2; i >= 0; i--){
                int depthSize = triangle[i].length;
                for(int j = 0; j < depthSize; j++){
                    triangle[i][j] = Math.max(triangle[i][j] + triangle[i+1][j], triangle[i][j] + triangle[i+1][j+1]);
                }
            }
            return triangle[0][0];
        }
    }