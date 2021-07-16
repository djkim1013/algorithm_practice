//BOJ: 2869
//2021.07.15
//category: 기본수학
//review:
//      - while문으로 작성 시 시간초과
//      - 나눗셈으로 작성 시 시간초과

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        int answer = v-a;
        if(answer<=0){
            System.out.println(1);
            sc.close();
            return;
        } 
        answer = answer/(a-b) + 1;
        System.out.println(++answer);
        sc.close();
    }
}
