import java.util.Arrays;

public class Solution {
    static final String DIA = "diamond", IRON = "iron", STONE = "stone";
    public int solution(int[] picks, String[] minerals) {
        int maximumIndexNumber = Arrays.stream(picks).sum();
        int mineChances = 5;
        int answer = 0;
        // sum을 기준으로 내림차순 정렬
        Node[] mineralSum = makeStonesMaximumSum(minerals, mineChances);
        for(Node node: mineralSum) {
            // 곡괭이의 갯수와 배열의 index가 같다면 도달할 수 없는 공간
            if(node.index == maximumIndexNumber) continue;
            answer += calcTiredness(picks, node);
        }

        return answer;
    }

    int calcTiredness(int[] picks, Node node){
        int result = 0;
        if(picks[0] > 0){
            result += node.diamondCount + node.ironCount + node.stoneCount;
            picks[0]--;
        }
        else if(picks[1] > 0){
            result += node.diamondCount * 5 + node.ironCount + node.stoneCount;
            picks[1]--;
        }
        else if(picks[2] > 0){
            result += node.diamondCount * 25 + node.ironCount * 5 + node.stoneCount;
            picks[2]--;
        }
        return result;

    }

    Node[] makeStonesMaximumSum(String[] minerals, int mineChances) {
        int mineralsLength = minerals.length;
        int resultSize = mineralsLength/mineChances + (mineralsLength%mineChances == 0 ? 0 : 1);
        Node[] result = new Node[resultSize];
        for(int s = 0; s < resultSize; s++){
            int sum = 0;
            int diamondCount = 0, ironCount = 0, stoneCount = 0;
            for(int p = s*mineChances; p < (s+1)*mineChances && p < mineralsLength; p++){
                String mineral = minerals[p];
                switch(mineral){
                    case DIA -> diamondCount++;
                    case IRON -> ironCount++;
                    case STONE -> stoneCount++;
                }
                sum += mineralValue(mineral);
            }
            result[s] = new Node(sum, s, diamondCount, ironCount, stoneCount);
        }
        Arrays.sort(result);
        return result;
    }

    int mineralValue(String mineral){
        if(mineral.equals(DIA)) return 25;
        if(mineral.equals(IRON)) return 5;
        // stone과 같은 상황
        return 1;
    }

    static class Node implements Comparable<Node>{
        int sum, index, diamondCount, ironCount, stoneCount;

        public Node(int sum, int index, int diamondCount, int ironCount, int stoneCount) {
            this.sum = sum;
            this.index = index;
            this.diamondCount = diamondCount;
            this.ironCount = ironCount;
            this.stoneCount = stoneCount;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "sum=" + sum +
                    ", index=" + index +
                    ", diamondCount=" + diamondCount +
                    ", ironCount=" + ironCount +
                    ", stoneCount=" + stoneCount +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return o.sum - this.sum;
        }
    }
}