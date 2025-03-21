import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        StringTokenizer st;
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();

        for(int i = 0; i < friends.length; i++) {
            map.put(friends[i], new HashMap<>());
            for(int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                map.get(friends[i]).put(friends[j], 0);
            }
        }

        for(String gift : gifts){
            st = new StringTokenizer(gift);
            String from = st.nextToken();
            String to = st.nextToken();
            HashMap<String, Integer> person = map.get(from);
            person.put(to, person.getOrDefault(to, 0) + 1);
        }

        HashMap<String, Integer> giftTradeMap = new HashMap<>();
        for(String key : map.keySet()){
            for(HashMap.Entry<String, Integer> entry : map.get(key).entrySet()){
                giftTradeMap.put(key, giftTradeMap.getOrDefault(key, 0) + entry.getValue());
                giftTradeMap.put(entry.getKey(), giftTradeMap.getOrDefault(entry.getKey(), 0) - entry.getValue());
            }
        }

        HashMap<String, Integer> receiveGift = new HashMap<>();
        for(String key : map.keySet()){
            for(HashMap.Entry<String, Integer> entry : map.get(key).entrySet()){
                String target = entry.getKey();
                if(map.get(key).get(target) > map.get(target).get(key)) receiveGift.put(key, receiveGift.getOrDefault(key, 0)+1);
                else if(map.get(key).get(target) == map.get(target).get(key) && giftTradeMap.get(key) > giftTradeMap.get(target)) receiveGift.put(key, receiveGift.getOrDefault(key, 0)+1);
            }
        }

        return receiveGift.values()
                .stream()
                .max(Integer::compare)
                .orElse(0);
    }
}