//BOJ 12015
//2021.10.22
//category: 이분탐색
//review:
//      - 탐색 중 만들고 있던 부분수열에 해당하는 값이 아니어도 현재까지의 최대 길이 부분수열은 바뀌지 않는 점을 이용한다.

import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> part=new ArrayList<Integer>();
        part.add(arr[0]);
        for(int i=1;i<n;i++){
            int t=arr[i];
            if(part.get(part.size()-1)<t){
                part.add(t);
            }else{
                int s=0,e=part.size()-1;
                while(s<=e){
                    int m=(s+e)/2;
                    if(part.get(m)==t){
                        s=m;
                        break;
                    }else if(part.get(m)<t){
                        s=m+1;
                    }else{
                        e=m-1;
                    }
                }
                part.set(s,t);
            }
        }
        System.out.println(part.size());
    }
}