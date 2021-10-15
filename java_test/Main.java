//BOJ 6549
//2021.10.15
//category: 분할정복
//review:
//      - 행렬의 제곱을 이용한다.
//       : {{An+2}, {An+1}} = {{1, 1},{1, 0}}x{{An+1}, {An}}
//      - n=1 일때 A0이 호출됨에 주의

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder answer=new StringBuilder();
        while((input=br.readLine()).charAt(0)!='0'){
            StringTokenizer st=new StringTokenizer(input);
            int n=Integer.parseInt(st.nextToken());
            int[] histogram=new int[n];
            for(int i=0;i<n;i++) histogram[i]=Integer.parseInt(st.nextToken());
            int max=-1;
            for(int i=0;i<n;i++){
                int h=histogram[i];
                int temp=0;
                for(int j=i-1;j>0;j--){
                    if(histogram[j]<h) break;
                    temp+=h;
                }
                for(int j=i;j<n;j++){
                    if(histogram[j]<h) break;
                    temp+=h;
                }
                max=Math.max(temp,max);
            }
            answer.append(max).append("\n");
        }
        System.out.print(answer);
    }
}