import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] doubleElements = new int[elements.length * 2];
        for(int e = 0; e < elements.length; e++){
            doubleElements[e] = elements[e];
            doubleElements[e + elements.length] = elements[e];
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < elements.length; i++){
            int sum = 0;
            for(int j = i; j < i + elements.length; j++){
                sum += doubleElements[j];
                set.add(sum);
            }
        }
        return set.size();
    }
}