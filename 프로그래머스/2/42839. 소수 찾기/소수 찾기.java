import java.util.HashSet;

class Solution {
        boolean[] visited = new boolean[7];
        HashSet<Integer> set = new HashSet<>();
        public int solution(String numbers) {
            int answer = 0;
            int len = numbers.length();
            makePermutation(numbers.toCharArray(), "", 0, len);
            for(int check: set) if(isPrime(check)) answer++;
            return answer;
        }
        void makePermutation(char[] numbers, String str, int depth, int len){
            if(depth > len) return;
            for(int i = 0; i < len; i++){
                if(visited[i]) continue;
                visited[i] = true;
                String newStr = str + numbers[i];
                set.add(Integer.parseInt(newStr));
                makePermutation(numbers, newStr, depth+1, len);
                visited[i] = false;
            }
        }

        boolean isPrime(int number){
            if(number < 2) return false;
            for(int i = 2; i <= Math.sqrt(number); i++) if(number % i == 0) return false;

            return true;
        }
    }
