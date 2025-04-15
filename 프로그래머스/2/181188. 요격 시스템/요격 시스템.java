import java.util.ArrayList;
import java.util.Collections;

class Solution {
        ArrayList<Target> targets = new ArrayList<>();
        int progress;
        public int solution(int[][] targets) {
            int answer = 0;
            for(int[] target : targets) this.targets.add(new Target(target[0], target[1]));
            Collections.sort(this.targets);
            // System.out.println(this.targets);
            for(Target target : this.targets){
                if(progress > target.start) continue;
                progress = target.end;
                answer++;
            }

            return answer;
        }
        class Target implements Comparable<Target>{
            int start, end;

            public Target(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public String toString() {
                return "Target{" +
                        "start=" + start +
                        ", end=" + end +
                        '}';
            }

            @Override
            public int compareTo(Target o) {
                return this.end - o.end;
            }
        }
    }
