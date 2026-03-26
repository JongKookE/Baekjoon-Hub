import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int tupleLength = relation.length;
        int attributeLength = relation[0].length;

        ArrayList<Integer> uniqueKey = new ArrayList<>();

        for(int currentBit = 1; currentBit <= (1 << attributeLength)-1; currentBit++){
            HashSet<String> set = buildSelectedBitSet(relation, currentBit, attributeLength);
            if(set.size() == tupleLength) uniqueKey.add(currentBit);
        }

        uniqueKey.sort(Comparator.comparingInt(Integer::bitCount));
        ArrayList<Integer> candidateKey = new ArrayList<>();
        for(int bit : uniqueKey){
            boolean isMinimal = true;
            for(int key : candidateKey){
                if((key & bit) == key){
                    isMinimal = false;
                    break;
                }
            }
            if(isMinimal) candidateKey.add(bit);
        }

        return candidateKey.size();
    }

    HashSet<String> buildSelectedBitSet(String[][] relation, int currentBit, int attributeLength){
        HashSet<String> set = new HashSet<>();
        for(String[] rel : relation){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < attributeLength; j++){
                // ex) currentBit = 1010, 1 << j == 0100 -> OR 연산을 했을때 0이 나온다면 현재 조합의 bit를 선택하지 않았기 때문에 스킵
                if((currentBit & (1 << j)) == 0) continue;
                sb.append(rel[j]).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            set.add(sb.toString());
        }
        return set;
    }
}
