//BOJ 5430
//2021.10.13
//category: 큐, 덱
//review:

import java.util.*;
import java.io.*;

class Main{
    static String run(int[] arr,String command){
        int order=1;
        int first=0,last=arr.length;
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='R'){
                order*=-1;
            }else{
                if(first==last) return "error";
                if(order>0) first++;
                else last--;
            }
        }
        arr=Arrays.copyOfRange(arr,first,last);
        if(order<0){
            int n=arr.length;
            for(int i=0;i<n/2;i++){
                int temp=arr[i];
                arr[i]=arr[n-i-1];
                arr[n-i-1]=temp;
            }
        }
        return Arrays.toString(arr).replace(" ","");
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String command=br.readLine();
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine(),"[,]");
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            System.out.println(run(arr,command));
        }
    }
}