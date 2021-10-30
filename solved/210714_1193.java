//BOJ: 1193
//2021.07.14
//category: 기본수학
//review:
//      -가장 작은값의 출력 확인
//      -수열의 순서 틀림(지그재그)

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer1 = 0;
        int answer2 = 1;
        int sum = 0;
        while((sum+=++answer1)<n);
        // System.out.println(sum);
        while(--sum>=n){
            answer1--;
            answer2++;
        }
        if((answer1+answer2)%2==0){
            int answer = answer1;
            answer1 = answer2;
            answer2 = answer;
        }
        System.out.println(answer1+"/"+answer2);
        sc.close();
    }
}