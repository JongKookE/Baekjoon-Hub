import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int indexCol = col-1;
        Arrays.sort(data, (arr1, arr2) ->{
            if(arr1[indexCol] == arr2[indexCol]) return Integer.compare(arr2[0], arr1[0]);
            return Integer.compare(arr1[indexCol], arr2[indexCol]);
        });

        for(int row = row_begin; row <= row_end; row++){
            int sum = 0;
            for(int i =0; i < data[0].length; i++){
                sum += (data[row-1][i] % row);
            }
            answer ^= sum;
        }

        return answer;
    }
}
