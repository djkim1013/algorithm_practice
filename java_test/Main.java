//BOJ 6549
//2021.10.16
//category: 분할정복
//review:

import java.util.*;
import java.io.*;

class Main{
    static final long MAXD=2*20000*20000;

    static long distance(int[] a,int[] b){
        long ret=(a[0]-b[0])*(a[0]-b[0]);
        ret+=(a[1]-b[1])*(a[1]-b[1]);
        return ret;
    }

    static long minDistance(ArrayList<int[]> arr,int start,int end){
        if(end-start<3){
            long ret=MAXD;
            for(int i=start;i<end;i++){
                for(int j=i+1;j<=end;j++){
                    ret=Math.min(ret,distance(arr.get(i),arr.get(j)));
                }
            }
            return ret;
        }
        int mid=(start+end)/2;
        long ret=Math.min(minDistance(arr,start,mid),minDistance(arr,mid+1,end));
        ArrayList<int[]> subArr=new ArrayList<int[]>();
        for(int i=mid;i>=start;i--){
            long dx=arr.get(mid)[0]-arr.get(i)[0];
            if(dx*dx>ret) break;
            subArr.add(arr.get(i));
        }
        for(int i=mid+1;i<=end;i++){
            long dx=arr.get(mid)[0]-arr.get(i)[0];
            if(dx*dx>ret) break;
            subArr.add(arr.get(i));
        }
        Collections.sort(subArr,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1]==b[1]) return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        for(int i=0;i+1<subArr.size();i++){
            ret=Math.min(ret,distance(subArr.get(i),subArr.get(i+1)));
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
                if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
        });
        System.out.println(minDistance(arr,0,n-1));
    }
}