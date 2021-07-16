//BOJ: 10757
//2021.07.16
//category: 기본수학
//review:
//      - 코드가 너무 복잡해져서 지움
//      - stringbuilder로 해결

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();
        StringBuilder a = new StringBuilder(input.substring(0,input.indexOf(" ")));
        StringBuilder b = new StringBuilder(input.substring(input.indexOf(" ")+1));
        a.reverse();
        b.reverse();
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<Math.max(a.length(),b.length());i++){
            int sum = 0;
            if(i<a.length()) sum+=Character.getNumericValue(a.charAt(i));
            if(i<b.length()) sum+=Character.getNumericValue(b.charAt(i));
            if(i<answer.length()) sum+=Character.getNumericValue(answer.charAt(i));
            else answer.append('0');
            if(sum>=10){
                answer.append((char)(sum/10+'0'));
                sum%=10;
            }
            answer.setCharAt(i,(char)(sum+'0'));
        }
        answer.reverse();
        out.write(answer.toString());
        out.flush();
    }
}