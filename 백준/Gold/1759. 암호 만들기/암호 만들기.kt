import java.io.BufferedReader
import java.io.InputStreamReader

var passwordLength = 0
var alphaCount = 0
var alphabetList = listOf<String>()
val moum = listOf('a', 'e', 'i', 'o', 'u')
val resultSB = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tokens: List<String> = br.readLine().trim().split(" ")
    passwordLength = tokens[0].toInt()
    alphaCount = tokens[1].toInt()
    alphabetList = br.readLine().trim().split(" ").sorted().toMutableList()
    val sb = StringBuilder()
    comb(0, 0, sb)
    println(resultSB)
}

fun comb(start: Int, cnt: Int, sb: StringBuilder){
    if(cnt == passwordLength){
        if(isRight(sb)) resultSB.append(sb).append("\n")
        return;
    }
    for(i in start until alphabetList.size){
        sb.append(alphabetList[i])
        comb(i+1, cnt+1, sb)
        sb.deleteCharAt(sb.length-1)
    }
}

fun isRight(sb: StringBuilder): Boolean{
    var moumCount = 0
    var jaumCount = 0

    for(ch in sb.toString().toCharArray()){
        if(moum.contains(ch)) moumCount++
        else jaumCount++
    }
    return moumCount >= 1 && jaumCount >= 2
}