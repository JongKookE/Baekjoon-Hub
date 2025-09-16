import java.util.Arrays;
import java.util.HashSet;

class Solution {
    int max = Integer.MIN_VALUE;
    public int solution(String numbers) {
        int size = numbers.length();
        int[] src = new int[size];
        HashSet<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[size];
        for(int i = 0; i < size; i++) src[i] = numbers.charAt(i) - '0';
        makePermutation(numbers.toCharArray(), new StringBuilder(), set, visited, 0);
        return getPrimeCount(set);
    }

    int getPrimeCount(HashSet<Integer> set){
        int answer = 0;
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= max; i++)
            if (isPrime[i])
                for (int j = i * i; j <= max; j += i)
                    isPrime[j] = false;

        for(int v : set) if(isPrime[v]) answer++;
        return answer;
    }

    void makePermutation(char[] src, StringBuilder sb, HashSet<Integer> set, boolean[] visited, int depth){
        if(depth == src.length) return;

        for(int i = 0; i < src.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            sb.append(src[i]);
            int permValue = Integer.parseInt(sb.toString());
            set.add(permValue);
            max = Math.max(permValue, max);
            makePermutation(src, sb, set, visited, depth+1);
            visited[i] = false;
            sb.setLength(sb.length()-1);
        }
    }
}
