//BOJ: 10809
//2021.07.14
//문제 분류: 문자열
//해결 분석: 

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char alphabet = 'a';
        for(int i=0;i<26;i++){
            // System.out.println(alphabet++);
            System.out.print(s.indexOf(alphabet++)+" ");    
        }
        sc.close();
    }
}
