import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val set = LinkedHashSet<String>()
    val pq = PriorityQueue<String>{ s1, s2 ->
        if(s1.length != s2.length) s1.length - s2.length
        else s1.compareTo(s2)
    }
    for (i in 0 until N) pq.add(br.readLine())
    while(!pq.isEmpty()) set.add(pq.poll())
    for (value in set) print("$value \n")
}