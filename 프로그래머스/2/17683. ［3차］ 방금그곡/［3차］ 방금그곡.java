import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public String solution(String m, String[] musicinfos) {
        ArrayList<MusicInfo> list = new ArrayList<>();
        m = getMelodyTokens(m);
        for(String musicInfo: musicinfos) {
            st = new StringTokenizer(musicInfo, ",");
            String start = st.nextToken();
            String end = st.nextToken();
            String title = st.nextToken();
            String melody = st.nextToken();
            int diff = calcDiffTime(start, end);
            MusicInfo info = new MusicInfo(diff, title, melody);
            if(!info.totalMelodies.contains(m)) continue;
            list.add(info);
        }
        Collections.sort(list);
        if(list.isEmpty()) return "(None)";
        return list.get(0).title;
    }

    int calcDiffTime(String start, String end){
        st = new StringTokenizer(start, ":");
        int startTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(end, ":");
        int endTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        return endTime - startTime;
    }

    static String getMelodyTokens(String melody){
        int i = 0;
        while (i < melody.length()) {
            char ch = melody.charAt(i);
            if (i + 1 < melody.length() && melody.charAt(i + 1) == '#') {
                sb.append(Character.toLowerCase(ch));
                i += 2;
            }
            else {
                sb.append(ch);
                i++;
            }
        }
        String result = sb.toString();
        sb.setLength(0);
        return result;
    }

    static class MusicInfo implements Comparable<MusicInfo>{
        int playTime;
        String title, melody, totalMelodies;

        public MusicInfo(int playTime, String title, String melody) {
            this.playTime = playTime;
            this.title = title;
            this.melody = getMelodyTokens(melody);
            this.totalMelodies = getTotalMelodies();
        }

        public String getTotalMelodies() {
            int melodyLength = this.melody.length();
            for(int time = 0; time < playTime; time++) sb.append(this.melody.charAt(time % melodyLength));

            String result = sb.toString();
            sb.setLength(0);
            return result;
        }

        @Override
        public String toString() {
            return "MusicInfo{" +
                    "playTime=" + playTime +
                    ", title='" + title + '\'' +
                    ", melody='" + melody + '\'' +
                    ", totalMelodies='" + totalMelodies + '\'' +
                    '}';
        }

        @Override
        public int compareTo(MusicInfo o) {
            if(o.playTime == this.playTime) return 0;
            return o.playTime - this.playTime;
        }
    }
}