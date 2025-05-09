import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val HP = 99
    val dp = IntArray(HP+1)
    val damageToken = StringTokenizer(br.readLine())
    val happyToken = StringTokenizer(br.readLine())

    val damages = IntArray(N)
    val happies = IntArray(N)

    for(n in 0 until N){
        damages[n] = damageToken.nextToken().toInt()
        happies[n] = happyToken.nextToken().toInt()
    }

    for(n in 0 until N){
        val damage = damages[n]
        val happy = happies[n]
        for(maxHP in HP downTo damage) dp[maxHP] = maxOf(dp[maxHP], dp[maxHP-damage] + happy)
    }
    println(dp[HP])
}