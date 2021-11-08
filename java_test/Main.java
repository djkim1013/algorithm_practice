//BOJ 11049
//2021.11.08
//category: 동적계획법
//review:

import java.io.*;

class Main{
    int[][] size;
    int mpCount(int left,int right){
        if(left+1==right)
            return size[left][0]*size[left][1]*size[right][1];
        int ret=0xfff0000;
        for(int i=left;i<right;i++){
            ret=Math.min(mpCount) 
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] size=new int[n][2];
        for(int i=0;i<n;i++){
            String input=br.readLine();
            size[i][0]=Integer.parseInt(input.substring(0,input.indexOf(" ")));
            size[i][1]=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        }
        
        br.close();
    }
}