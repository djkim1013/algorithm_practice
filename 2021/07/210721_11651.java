//BOJ: 11651
//2021.07.21
//category: 정렬
//review:

import java.io.*;
import java.util.*;

public class Main {
    
    static public class Location implements Comparable<Location>{
        Integer x;
        Integer y;
        public Location(int x,int y){
            this.x=x;
            this.y=y;
        }
        public int compareTo(Location other){
            if(y.compareTo(other.y)==0) return x.compareTo(other.x);
            return y.compareTo(other.y);

        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        Location[] arr = new Location[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[i]=new Location(x,y);
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            out.write(arr[i].x+" "+arr[i].y);
            out.newLine();
        }
        out.flush();
    }
}