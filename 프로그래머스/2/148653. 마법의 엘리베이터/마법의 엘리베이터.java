import java.util.*;
// dp or bfs 근데 범위가 1억이니까 dp 일거같은데..
// 단순계산 ㅎ
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int lastDigit = (storey % 10);
             if (lastDigit > 5) {
                answer += (10 - lastDigit);
                storey = (storey / 10) + 1;
            } 
            else if (lastDigit < 5) {
                answer += lastDigit;
                storey = storey / 10;
            }

            else { 
                int nextDigit = (storey / 10) % 10;
                if (nextDigit >= 5) {
                    answer += (10 - lastDigit);
                    storey = (storey / 10) + 1;
                } else {
                    answer += lastDigit;
                    storey = storey / 10;
                }
            }
        }
        return answer;
    }
}