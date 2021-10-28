//BOJ: 1157
//2021.07.14
//문제 분류: 문자열
//해결 분석: 문제 파악 실수가 반복됨 - 예재 출력을 먼저 보고 작성하자

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String vocab = sc.next();
        int upperLower = 'a'-'A';
        int[] count = new int[26];
        Arrays.fill(count,0);
        int max = -1;
        char maxC = '0';
        for(int i=0;i<vocab.length();i++){
            int c = vocab.charAt(i)-'A';
            if(c>26) c-=upperLower;
            count[c]++;
            max = Math.max(max,count[c]);
        }
        for(int i=0;i<26;i++){
            if(max==count[i]){
                if(maxC=='0') maxC = (char)(i+'A');
                else {
                    maxC = '?';
                    break;
                }
            }
        }
        System.out.println(maxC);
        sc.close();
    }
}