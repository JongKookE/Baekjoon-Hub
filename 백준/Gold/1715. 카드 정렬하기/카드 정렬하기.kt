import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val pq = PriorityQueue<Int>()
    for(n in 0 until N) pq.add(br.readLine().toInt())

    var result = 0
    while(pq.size > 1){
        val sum = pq.poll() + pq.poll()
        result += sum
        pq.add(sum)
    }
    println(result)
}