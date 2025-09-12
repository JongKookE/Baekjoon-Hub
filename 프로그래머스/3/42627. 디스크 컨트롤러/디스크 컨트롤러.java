import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int size = 0;
        int index = 0;
        int end = 0;
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        while(size < jobs.length){
            while(index < jobs.length && jobs[index][0] <= end) pq.add(jobs[index++]);
            if(pq.isEmpty()) end = jobs[index][0];
            else {
                int[] current = pq.poll();
                System.out.println(Arrays.toString(current));
                answer += current[1] + end - current[0];
                end += current[1];
                size++;
            }
        }



        return answer/jobs.length;
    }

}
