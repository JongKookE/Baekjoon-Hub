import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer? = null
    val N = br.readLine().toInt()
    val pq = PriorityQueue<Node>()
    var result: Int = 0

    for(n in 0 until N){
        st = StringTokenizer(br.readLine())
        pq.add(Node(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    var current = pq.poll()

    while(!pq.isEmpty()){
        val next = pq.poll()
        if(current.isConnected(next)) current.end = maxOf(current.end, next.end)
        else {
            result += calc(current);
            current = next
        }
    }
    result += calc(current);
    println(result)
}

fun calc(node: Node): Int{
    return node.end - node.start
}

data class Node(var start: Int, var end: Int) : Comparable<Node>{
    fun isConnected(next: Node): Boolean{
        return this.end >= next.start
    }

    override fun compareTo(other: Node): Int {
        if(this.start == other.start) return this.end - other.end
        return this.start - other.start
    }
}