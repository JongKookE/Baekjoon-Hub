import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution{
    public double[] solution(int k, int[][] ranges) {
        int[] collatzNumbers = toCollatz(k);
        int n = collatzNumbers.length - 1;
        double[] answer = new double[ranges.length];
        double[] prefixSum = new double[collatzNumbers.length];
        for(int i = 1; i < collatzNumbers.length; i++){
            double high = collatzNumbers[i];
            double low = collatzNumbers[i-1];
            prefixSum[i] = (high + low)/2 + prefixSum[i-1];
        }

        for(int i = 0; i < ranges.length; i++){
            int[] range = ranges[i];
            int start = range[0];
            int end = n - Math.abs(range[1]);
            if(end - start <= 0){
                answer[i] = end - start == 0 ? 0.0 : -1.0;
                continue;
            }
            answer[i] = prefixSum[end] - prefixSum[start];
        }

        return answer;
    }

    private int[] toCollatz(int k){
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(k > 1){
            k = k%2 == 0 ? k/2 : k * 3 + 1;
            list.add(k);
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}