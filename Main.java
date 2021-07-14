//BOJ: 2941
//2021.07.14
//category: 문자열
//review: for문 흐름 주의, 복붙 오타 주의
//          if-else if 문을 연달아 쓸때 조건문 흐름 확인

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        int answer = 0;
        for(int i=0;i<str.length;i++){
            if(i+1<str.length){
                if(str[i]=='c'&&(str[i+1]=='='||str[i+1]=='-')){
                    i++;
                }else if((str[i]=='l'||str[i]=='n')&&str[i+1]=='j'){
                    i++;
                }else if(str[i]=='z'&&str[i+1]=='='){
                    i++;
                }
            }
            if(i+2<str.length){
                if(str[i]=='d'&&str[i+1]=='z'&&str[i+2]=='='){
                    i+=2;
                }
            }
            answer++;
        }
        System.out.println(answer);
        sc.close();
    }
}