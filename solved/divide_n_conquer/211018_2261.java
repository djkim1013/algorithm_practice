//BOJ 2261
//2021.10.18
//category: 분할정복
//review:
//      - 마지막 y 비교는 전체 경우의수를 비교해야한다고 생각했지만,
//          이미 x가 가까운 경우는 계산된 후 이므로 중복계산이다.
//      - 최솟값을 비교할때 분할정복이 계산과정을 훨씬 줄여준다.

import java.util.*;
import java.io.*;

class Main{
    static final int MAXD=2*20000*20000;

    static int distance(int[] a,int[] b){
        int dx=a[0]-b[0];
        int dy=a[1]-b[1];
        return dx*dx+dy*dy;
    }

    static int minDistanceY(ArrayList<int[]> arr,int start,int end){
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
        return Math.min(minDistanceY(arr,start,mid),minDistanceY(arr,mid,end));
    }

    static int minDistanceX(ArrayList<int[]> arr,int start,int end){
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
        int ret=Math.min(minDistanceX(arr,start,mid),minDistanceX(arr,mid+1,end));
        ArrayList<int[]> subArr=new ArrayList<int[]>();
        for(int i=mid;i>=start;i--){
            int dx=arr.get(mid)[0]-arr.get(i)[0];
            if(dx*dx>ret) break;
            subArr.add(arr.get(i));
        }
        for(int i=mid+1;i<=end;i++){
            int dx=arr.get(mid)[0]-arr.get(i)[0];
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
        ret=Math.min(ret,minDistanceY(subArr,0,subArr.size()-1));
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
        System.out.println(minDistanceX(arr,0,n-1));
    }
}