//BOJ: 14888
//2021.07.25
//category: backtracking
//review:
//      - 자바에서 재귀함수 사용 시 C++과 달리 호출한 함수에게도 영향을 미치는 점에 주의
//          : 호출된 함수 끝에 전달한 배열을 원상복귀 시키지 않았더니 오류 발생

import java.util.*;
import java.io.*;

public class Main{
    static int n, max=-1000000000, min=1000000000;
    static int[] numbers;

    static void tryAllcomb(int idx,int result,int[] operators){
        if(idx==n){
            if(result<min) min=result;
            if(result>max) max=result;
            return;
        }
        if(operators[0]>0){
            operators[0]--;
            tryAllcomb(idx+1,result+numbers[idx],operators);
            operators[0]++;
        }
        if(operators[1]>0){
            operators[1]--;
            tryAllcomb(idx+1,result-numbers[idx],operators);
            operators[1]++;
        }
        if(operators[2]>0){
            operators[2]--;
            tryAllcomb(idx+1,result*numbers[idx],operators);
            operators[2]++;
        }
        if(operators[3]>0){
            operators[3]--;
            tryAllcomb(idx+1,result/numbers[idx],operators);
            operators[3]++;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        numbers=new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        for(int i=0;i<n;i++){
            numbers[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        int[] operators = new int[4];
        // 0:+,1:-,2:*,3:/
        for(int i=0;i<4;i++){
            operators[i]=Integer.parseInt(st.nextToken());
        }
        tryAllcomb(1,numbers[0],operators);
        System.out.println(max);
        System.out.println(min);
    }
}