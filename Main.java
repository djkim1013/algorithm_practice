//BOJ: 2839
//2021.07.16
//category: 기본수학
//review:
//      while 경계값 주의

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int nMod5 = n%5;
        int answer = n/5;
        while(nMod5<=n){
            if(nMod5%3==0){
                answer+=nMod5/3;
                break;
            }
            nMod5+=5;
            answer--;
        }
        if(nMod5>n)answer=-1;
        out.write(answer+"\n");
        out.flush();
    }
}