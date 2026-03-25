import java.util.HashSet;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int tupleLength = relation.length;
        int attributeLength = relation[0].length;
        HashSet<Integer> set = new HashSet<>();
        comb(0, attributeLength, 0, set);
        for(int bit : set) {
            HashSet<String> stringHashSet = setByComb(bit, relation);
            System.out.println(stringHashSet);

        }
        return answer;
    }

    HashSet<String> setByComb(int bit, String[][] relation){
        HashSet<String> set = new HashSet<>();
        for(String[] relationArray : relation){
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for(int j = 0; j < relationArray.length; j++){
                if((bit & 1 << j) == 0) continue;
                sb.append(relationArray[j]).append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
            set.add(sb.toString());
        }
        return set;
    }

    void comb(int start, int attributeLength, int bit, HashSet<Integer> set){
        for(int i = start; i < attributeLength; i++){
            int nextBit = bit | (1 << i);
            set.add(nextBit);
            comb(i + 1, attributeLength, nextBit, set);
        }
    }
}
