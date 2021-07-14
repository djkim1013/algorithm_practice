//BOJ: 2675
//2021.07.14
//문제 분류: 문자열
//해결 분석: 문제 파악 실수가 반복됨 - 예재 출력을 먼저 보고 작성하자

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            StringBuilder answer = new StringBuilder();
            int r = sc.nextInt();
            String str = sc.next();
            for(int j=0;j<str.length();j++){
                for(int k=0;k<r;k++){
                    answer.append(str.charAt(j));
                }
            }
            System.out.println(answer);
        }
        sc.close();
    }
}