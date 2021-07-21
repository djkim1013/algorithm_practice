//BOJ: 2108
//2021.07.21
//category: 정렬
//review:
//      -반올림 함수:Math.round()
//      -mode 계산: 두번째로 작은 수를 고르는 방법 틀림
//      -함수 분리

import java.io.*;
import java.util.*;

public class Main {

    int mean(int[] arr){
        int answer = 0;
        for(int i:arr){
            answer+=i;
        }
        return (int)Math.round((double)answer/arr.length);
    }

    int mode(int[] arr){
        int answer = 0;
        int[] count=new int[arr[arr.length-1]-arr[0]+1];
        int maxCount=0;
        boolean dup=false;
        for(int i:arr){
            count[i-arr[0]]++;
        }
        for(int i=0;i<count.length;i++){
            if(maxCount>count[i])continue;
            if(maxCount==count[i]){
                if(dup) continue;
                dup=true;
            }else{
                dup=false;
            }
            answer=arr[0]+i;
            maxCount=count[i];
        }
        return answer;
    }


    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        Main m = new Main();

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(in.readLine());
        }
        Arrays.sort(arr);
        
        out.write(m.mean(arr)+"\n");
        
        out.write(arr[n/2]+"\n");
                
        out.write(m.mode(arr)+"\n");
        
        out.write(arr[n-1]-arr[0]+"\n");
        
        out.flush();
    }
}