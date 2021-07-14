//BOJ: 1193
//2021.07.14
//category: 기본수학
//review:
//      - 1,1+6,1+6+12,...순으로 층이 멀어지며 같은 층은 최소 층수만큼의 방을 거치면 갈 수 있다.
//      - 처음과 끝이 포함되므로 마지막에 +1되어야 정답
//      - while문 경계값 주의

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer1 = 1;
        int answer2 = 1;
        int sum = 1;
        while((sum+=++answer1)<n);
        // System.out.println(sum);
        while(--sum>=n){
            answer1--;
            answer2++;
        }
        System.out.println(answer2+"/"+answer1);
        sc.close();
    }
}