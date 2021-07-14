//BOJ: 2869
//2021.07.14
//category: 기본수학
//review:

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();
        int h = 0;
        int answer = 1;
        while((h+=a)<v){
            answer++;
            h-=b;
        }
        System.out.println(answer);
        sc.close();
    }
}