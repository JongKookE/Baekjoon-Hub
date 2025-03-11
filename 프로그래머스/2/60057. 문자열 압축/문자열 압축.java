import java.util.*;
class Solution {
    public int solution(String s) {
        int length = s.length();
        int answer = s.length();
        ArrayList<String> strings;
        for (int i = 1; i <= length / 2; i++) {
            StringBuilder sb = new StringBuilder();
            strings = new ArrayList<>() {{
                add(null);
            }};
            for (int j = 0; j < length; j += i) {
                int end = Math.min(j + i, length);
                sb.append(s, j, end);
                strings.add(sb.toString());
                sb.setLength(0);
            }
            answer = Math.min(answer, compressionLength(strings));
        }

        return answer;
    }
    int compressionLength(ArrayList<String> strings) {
        StringBuilder sb = new StringBuilder();
        int size = strings.size();
        // 0번째는 더미 데이터
        int count = 1;
        for(int i = 1; i < size-1; i++){
            String current = strings.get(i);
            String next = strings.get(i+1);
            if(current.equals(next)) count++;
            else{
                if(count == 1) sb.append(current);
                else sb.append(count).append(current);
                count = 1;
            }
        }

        if(count == 1) sb.append(strings.get(size-1));
        else sb.append(count).append(strings.get(size-1));
        return sb.length();
    }
}