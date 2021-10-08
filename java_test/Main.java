//BOJ: 1010
//2021.10.08
//category: 정수론 및 조합론
//review:

import java.util.*;
import java.io.*;

class Main{
    static int left,right;
    static int countCase(int l,int r){
        if(l==left) return 1;
        if(r==right) return 0;
        return countCase(l+1,r+1)+countCase(l,r+1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder answer=new StringBuilder();
        while(t-->0){
            st=new StringTokenizer(br.readLine()," ");
            left=Integer.parseInt(st.nextToken());
            right=Integer.parseInt(st.nextToken());
            answer.append(countCase(0,0)).append("\n");
        }
        System.out.println(answer);
    }
}