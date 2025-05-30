import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        PriorityQueue<Route> pq = new PriorityQueue<>();
        for(int[] route : routes) pq.add(intArrayToRoute(route));

        Route startRoute = pq.poll();

        int prevEnd = startRoute.end;

        while(!pq.isEmpty()) {
            // end를 기준으로 정렬되서 내려옴
            Route nextRoute = pq.poll();
             if(prevEnd < nextRoute.start) {
                 answer++;
                 prevEnd = nextRoute.end;
             }
        }

        return answer;
    }

    Route intArrayToRoute(int[] arr){
        return new Route(arr[0], arr[1]);
    }
    class Route implements Comparable<Route> {
        int start, end;

        public Route(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Route o) {
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
