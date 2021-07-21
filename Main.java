//BOJ: 2108
//2021.07.21
//category: 정렬
//review:
//      -반올림 함수:Math.round()
//      -mode 계산법 실수

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);
        int answer=0;
        //mean
        for(int i:arr){
            answer+=i;
        }
        answer=(int)Math.round((double)answer/n);
        out.write(answer+"\n");
        //middle value
        answer=arr[n/2];
        out.write(answer+"\n");
        //mode
        
        out.write(answer+"\n");
        //range
        answer=arr[n-1]-arr[0];
        out.write(answer+"\n");
        out.flush();
    }
}