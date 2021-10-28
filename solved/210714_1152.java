//BOJ: 1152
//2021.07.14
//category: 문자열
//review: 각 char 하나씩 입력할 때는 Scanner없이 System.in.read() 사용

// import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int pre = ' ';
        int cur = 0;
        int answer = 0;
        while((cur=System.in.read())>=32){
            if(cur!=' '&&pre==' ') answer++;
            pre=cur;
        }
        System.out.println(answer);
    }
}