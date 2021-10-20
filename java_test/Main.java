//BOJ 1654
//2021.10.19
//category: 이분탐색
//review:
//      - 모든 랜선을 사용해야하는 것은 아니다.

import java.io.*;
import java.util.*;

class Main{
    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int k=Integer.parseInt(input.substring(0,input.indexOf(" ")));
        int n=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        Integer[] arr=new Integer[k];
        for(int i=0;i<k;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=arr[k-1];i>=1;i--){
            int sum=0;
            int count=i;
            for(int j=0;j<k;j++){
                if(arr[j]>=count){
                    sum+=k-j;
                    count+=i;
                    j--;
                }
            }
            if(sum>=n){
                System.out.println(i);
                return;
            }
        }
    }
}

/* 
<case 1>
4 11
802
743
457
539
answer : 200

<case 2>
4 5
10
1
1
1
answer : 2

*/