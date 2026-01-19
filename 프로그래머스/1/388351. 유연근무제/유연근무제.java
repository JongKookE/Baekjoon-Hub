class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i < schedules.length; i++){
            boolean cut = false;
            for(int j = 0; j < 7; j++){
                int timeLog = timelogs[i][j];
                if(isWeekend(startday + j)) continue;
                if(isLate(toMinute(schedules[i]), toMinute(timeLog))) {
                    cut = true;
                    break;
                }
            }

            if(!cut) answer++;
        }

        return answer;
    }

    public int toMinute(int time){
        return (time/100) * 60 + time % 100;
    }

    public boolean isLate(int schedule, int timeLog){
        return schedule + 10 < timeLog ;
    }

    public boolean isWeekend(int currentDay){
        return currentDay % 7 == 6 || currentDay % 7 == 0;
    }
}