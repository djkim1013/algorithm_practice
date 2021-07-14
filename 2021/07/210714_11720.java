//BOJ: 11720
//2021.07.14
//문제 분류: 문자열
//해결 분석: int Character.getNumericValue(Char ch)

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int answer = 0;
        for(int i=0;i<n;i++){
            answer+=Character.getNumericValue(str.charAt(i));
        }
        System.out.println(answer);
        sc.close();
    }
}
