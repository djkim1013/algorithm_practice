//BOJ: 11654
//2021.07.14
//문제 분류: 문자열
//해결 분석: Java는 C/C++와 달리 char을 정수로 인식하지 않는다.

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println((byte)str.charAt(0));
        sc.close();
    }
}
