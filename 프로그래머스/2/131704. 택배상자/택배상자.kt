import java.util.Stack

class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val stack: Stack<Int> = Stack<Int>()
        for(i in 0 until order.size){
            if(i+1 == order[answer]) answer++
            else stack.add(i+1)
            while(!stack.isEmpty() && stack.peek() == order[answer]){
                answer++;
                stack.pop()
            }
        }
        return answer
    }
}