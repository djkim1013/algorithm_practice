//BOJ 11049
//2021.11.08
//category: 동적계획법
//review:

import java.io.*;

class Main{
    static int[][] size, cache;
    static int mpCount(int left,int right){
        if(left+1==right)
            return size[left][0]*size[left][1]*size[right][1];
        if(cache[left][right]!=0) return cache[left][right];
        int nk=size[left][0]*size[right][1];
        int ret=mpCount(left+1,right)+nk*size[left][1];
        ret=Math.min(
            ret,
            mpCount(left,right-1)+nk*size[right][0]
        );
        for(int i=left+1;i+2<right;i++){
            ret=Math.min(
                ret,
                mpCount(left,i)+mpCount(i+1,right)+nk*size[i][1]
            );
        }
        return cache[left][right]=ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        size=new int[n][2];
        cache=new int[n][n];
        for(int i=0;i<n;i++){
            String input=br.readLine();
            size[i][0]=Integer.parseInt(input.substring(0,input.indexOf(" ")));
            size[i][1]=Integer.parseInt(input.substring(input.indexOf(" ")+1));
        }
        System.out.println(mpCount(0,n-1));
        br.close();
    }
}
