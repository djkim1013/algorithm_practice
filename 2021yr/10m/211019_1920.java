//BOJ 1920
//2021.10.19
//category: 분할정복
//review:

import java.io.*;
import java.util.*;

class Main{
    static int search(int[] data,int target,int start,int end){
        if(end==start){
            return data[start]==target?1:0;
        }
        int mid=(start+end)/2;
        if(target==data[mid]) return 1;
        if(target<data[mid]) return search(data,target,start,mid);
        return search(data,target,mid+1,end);
    }
    
    static public void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] data=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) data[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(data);
        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<m;i++){
            int target=Integer.parseInt(st.nextToken());
            answer.append(search(data,target,0,n-1)).append("\n");
        }
        System.out.println(answer);
    }
}