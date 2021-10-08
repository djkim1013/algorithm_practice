//BOJ: 1712
//2021.07.14
//category: 기본수학
//review: 예외처리 항상 주의

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if(c-b<=0){
            System.out.println(-1);
            sc.close();
            return;
        }
        
        int sum = -a;
        int answer = 0;
        while(sum<=0){
            sum+=c-b;
            answer++;
        }
        System.out.println(answer);
        sc.close();
    }
}