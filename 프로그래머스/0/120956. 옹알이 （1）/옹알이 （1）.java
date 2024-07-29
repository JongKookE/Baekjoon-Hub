import java.util.*;

class Solution {
    String[] words = { "aya", "ye", "woo", "ma"};
    String[] src;
    boolean[] visited;
    public int solution(String[] babbling) {
        int answer = 0;
        int length = babbling.length;
        int replaceTime = words.length;
        for(int i = 0; i < length; i++){
            String babbl = babbling[i];
            for(int j = 0; j < replaceTime; j++){
                babbl = babbl.replace(words[j], " ");
            }
            if(babbl.trim().length() == 0) answer++;
        }
        return answer;
    }

}