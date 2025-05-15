import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    val dq : Deque<Int> = ArrayDeque()
    for(n in 1 .. N) dq.addLast(n)
    sb.append("<")
    var iter = 1
    while(!dq.isEmpty()) {
        if(iter % K == 0) sb.append(dq.pollFirst()).append(", ")
        else dq.addLast(dq.pollFirst())
        iter++
    }
    sb.setLength(sb.length - 2)
    sb.append(">")
    println(sb)
}