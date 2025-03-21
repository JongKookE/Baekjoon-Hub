import java.util.ArrayList;
import java.util.StringTokenizer;
class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        ArrayList<StartEndTime> times = new ArrayList<>();
        StringTokenizer st;
        for(String line : lines){
            st = new StringTokenizer(line);
            st.nextToken();
            String time = st.nextToken();
            double duration = Double.parseDouble(st.nextToken().replaceAll("s", "")) * 1000;
            st = new StringTokenizer(time, ":");
            double hour = Double.parseDouble(st.nextToken()) * 3600;
            double minute = Double.parseDouble(st.nextToken()) * 60;
            double second = Double.parseDouble(st.nextToken());
            double endTime = (hour + minute + second) * 1000;
            double startTime = endTime - duration + 1;
            times.add(new StartEndTime(startTime, endTime));
        }

        for(StartEndTime time : times){
            double startTime = time.startTime;
            double endTime = time.endTime;
            answer = Math.max(answer, includedLog(times, startTime));
            answer = Math.max(answer, includedLog(times, endTime));
        }
        return answer;
    }
    static int includedLog(ArrayList<StartEndTime> times, double startTime){
        int answer = 0;
        double endTime = startTime + 1000;
        for(StartEndTime time: times){
            if(time.startTime >= endTime || time.endTime < startTime) continue;
                answer++;
        }
        return answer;

    }
    static class StartEndTime{
        double startTime, endTime;

        public StartEndTime(double startTime, double endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return String.format("s=%.0f, e=%.0f", startTime, endTime);
        }
    }
}