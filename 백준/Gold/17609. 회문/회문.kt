import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val n = br.readLine().toInt()

    repeat(n){
        val str = br.readLine()
        sb.append(calcPalindrome(str, 0, str.length-1, 0)).append("\n")
    }
    println(sb)
}

fun calcPalindrome(str: String, start: Int, end: Int, depth: Int): Int{
    if(depth >= 2) return 2

    var currentStart = start
    var currentEnd = end
    
    while(currentStart < currentEnd){
        if(str[currentStart] == str[currentEnd]) {
            currentStart++
            currentEnd--
        }
        else return minOf(calcPalindrome(str, currentStart + 1, currentEnd, depth+1), calcPalindrome(str, currentStart, currentEnd - 1, depth+1))
    }
    return depth
}