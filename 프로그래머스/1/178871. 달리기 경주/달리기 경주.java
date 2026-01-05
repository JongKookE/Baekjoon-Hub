import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++) map.put(players[i], i);
        

        for(String callPlayer : callings){
            int callPlayerRanking = map.get(callPlayer);
            String frontPlayer = players[callPlayerRanking - 1];

            players[callPlayerRanking - 1] = callPlayer;
            players[callPlayerRanking] = frontPlayer;

            map.put(callPlayer, callPlayerRanking - 1);
            map.put(frontPlayer, map.get(frontPlayer) + 1);
        }

        return players;
    }
}