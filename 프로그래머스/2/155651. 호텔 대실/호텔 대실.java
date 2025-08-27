import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        // 최대 23:59분
        int[] isNotAvailableTime = new int[60 * 24 -1];
        int[][] times = bookTimeToNumberFormat(book_time);
        for(int[] t : times){
            int start = t[0];
            int end = Math.min(t[1]+10, 60 * 24 - 1);
            for(int s = start; s < end; s++) isNotAvailableTime[s]++;
        }

        return Arrays.stream(isNotAvailableTime)
                .max().getAsInt();

    }

    int[][] bookTimeToNumberFormat(String[][] book_time){
        return Arrays.stream(book_time)
                .map(timeSlot -> Arrays.stream(timeSlot)
                        .mapToInt(this::dateToNumber)
                        .toArray())
                .toArray(int[][]::new);
    }

    int dateToNumber(String time){
        String[] timeStr = time.split(":");
        int hour = Integer.parseInt(timeStr[0]) * 60;
        int minute = Integer.parseInt(timeStr[1]);
        return hour + minute;
    }
}