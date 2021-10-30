//BOJ: 5622
//2021.07.14
//category: 문자열
//review: 

import java.util.*;

public class Main {
    static int dial(char c){
        if(c<'D') return 3;
        if(c<'G') return 4;
        if(c<'J') return 5;
        if(c<'M') return 6;
        if(c<'P') return 7;
        if(c<'T') return 8;
        if(c<'W') return 9;
        return 10;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int answer = 0;
        for(char c:str){
            answer+=dial(c);
        }
        System.out.println(answer);
        sc.close();
    }
}