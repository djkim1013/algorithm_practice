//BOJ 11066
//2021.10.29
//category: 동적계획법
//review:

import kotlin.math.min;

fun main(){
  val br=System.`in`.bufferedReader()
  val bw=System.out.bufferedWriter()
  repeat(br.readLine().toInt()){
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map{it.toInt()}
    val sum=IntArray(n+1)
    for(i in 1 .. n) sum[i]=sum[i-1]+arr[i-1]
    val dp=Array(n+1){IntArray(n+1)}
    for(i in 1..n-1){
      for(s in 1..n-i ){
        val e=s+i
        dp[s][e]=Int.MAX_VALUE
        for(j in s..e-1)
          dp[s][e]=min(dp[s][e],dp[s][j]+dp[j+1][e]+sum[e]-sum[s-1])
      }
    }
    bw.write("${dp[1][n]}\n")
  }
  bw.flush()
}