import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int targetCount = targets.length;
        int[] answer = new int[targetCount];
        HashMap<Character, Integer> map = new HashMap<>();
        int keymapCount = keymap.length;
        int keyLength = keymap[0].length();
        
        for(int c = 0; c < keymapCount; c++){
            char[] chs = keymap[c].toCharArray();
            int chLength = chs.length;
            for(int cl = 0; cl < chLength; cl++){
                char ch = chs[cl];
                if(!map.containsKey(ch)) map.put(ch, cl+1);
                else map.put(ch, Math.min(map.get(ch), cl+1));
            }
        }
        
        for(int t = 0; t < targetCount; t++){
            int targetLength = targets[t].length();
            int count = 0;
            for(int tl = 0; tl < targetLength; tl++){
                char target = targets[t].charAt(tl);
                if(!map.containsKey(target)) {
                    count = -1;
                    break;
                }
                count += map.get(target);
            }
            answer[t] = count;
        }
        System.out.println(map);
        return answer;
    }
}