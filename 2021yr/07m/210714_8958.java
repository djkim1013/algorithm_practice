//BOJ: 8958
//2021.07.14
//문제 분류: 1차원 배열
//해결 분석: O이 연속된 만큼 얻는 점수가 커진다 - 문제를 잘 파악 할 것

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            String quize = sc.next();
            int answer = 0;
            int count = 0;
            for(int j = 0; j < quize.length(); j++){
                if(quize.charAt(j) == 'O'){
                    count++;
                    answer += count;
                    continue;
                }
                count = 0;
            }
            System.out.println(answer);
        }
        sc.close();
    }
}
