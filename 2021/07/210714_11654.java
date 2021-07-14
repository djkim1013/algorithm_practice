//BOJ: 11654
//2021.07.14
//문제 분류: 문자열
//해결 분석: Scanner 와 println에서 변수 타입 주의.

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println((byte)str.charAt(0));
        sc.close();
    }
}
