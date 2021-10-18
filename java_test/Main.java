//BOJ 2261
//2021.10.18
//category: 분할정복
//review:

import java.util.*;
import java.io.*;

class Main{
    static final int MAXD=2*20000*20000;

    static int distance(int[] a,int[] b){
        int ret=(a[0]-b[0])*(a[0]-b[0]);
        ret+=(a[1]-b[1])*(a[1]-b[1]);
        return ret;
    }

    static int minDistance(ArrayList<int[]> arr,int start,int end){
        if(end-start<3){
            int ret=MAXD;
            for(int i=start;i<end;i++){
                for(int j=i+1;j<=end;j++){
                    ret=Math.min(ret,distance(arr.get(i),arr.get(j)));
                }
            }
            return ret;
        }
        int mid=(start+end)/2;
        int ret=Math.min(minDistance(arr,start,mid),minDistance(arr,mid+1,end));
        int s=mid,e=mid+1;
        for(;s>start;s--){
            int dx=arr.get(mid)[0]-arr.get(s)[0];
            if(dx*dx>ret) break;
        }
        for(;e<end;e++){
            int dx=arr.get(mid)[0]-arr.get(e)[0];
            if(dx*dx>ret) break;
        }
        Collections.sort(arr.subList(s,e+1),new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        for(int i=s;i<e;i++){
            for(int j=i+1;j<=e;j++){
                int dy=arr.get(i)[1]-arr.get(j)[1];
                if(dy*dy>ret) break;
                ret=Math.min(ret,distance(arr.get(i),arr.get(j)));
            }
        }
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<int[]> arr=new ArrayList<int[]>();
        for(int i=0;i<n;i++){
            String input=br.readLine();
            int[] temp=new int[2];
            temp[0]=Integer.parseInt(input.substring(0,input.indexOf(" ")));
            temp[1]=Integer.parseInt(input.substring(input.indexOf(" ")+1));
            arr.add(temp);
        }
        Collections.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        System.out.println(minDistance(arr,0,n-1));
    }
}