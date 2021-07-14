//BOJ: 1546
//2021.07.14
//문제 분류: 1차원 배열
//해결 분석: 

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        int m = -1;
        double answer = 0.;
        
        for(int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
        }
        
        for(int s : scores){
            m = Math.max(s,m);
        }
        
        for(int s : scores){
            answer += (double)s/m*100;
        }
        answer/=(double)n;

        System.out.println(answer);
        
        sc.close();
    }
}
