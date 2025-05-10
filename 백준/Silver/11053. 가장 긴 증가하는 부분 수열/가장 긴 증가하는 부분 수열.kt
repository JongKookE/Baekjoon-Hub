import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val numbers : IntArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var dp  = IntArray(N+1)
    var result = 0
    // 인덱스를 기준으로 처음부터 자기자신까지 오는 수 중 자기보다 작은 수를 비교
    for(i in 1 .. N) {
        // 자기자신은 증가하는 부분에 포함함
        dp[i] = 1
        for(j in 1 .. i){
            if(numbers[i-1] <= numbers[j-1]) continue;
            dp[i] = maxOf(dp[i],dp[j]+1)
        }
        result = maxOf(result, dp[i])
    }
    println(result)
}