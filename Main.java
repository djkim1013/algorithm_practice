//BOJ: 11729
//2021.07.19
//category: 재귀함수 구현
//review:

import java.io.*;
import java.util.*;

public class Main {
    static final int[][] rest = new int[][]{{-1,2,1},{2,-1,0},{1,0,-1}};
    static StringBuilder log = new StringBuilder();
    static ArrayList<ArrayList<Integer>> top=new ArrayList<ArrayList<Integer>>();
    static int movePlate(int target,int start,int end){
        if(top.get(start).get(0)==target&&top.get(0).get(0)<target){
            top.get(start).remove(0);
            top.get(0).add(0,target);
            log.append(start+" "+end+"\n");
            return 1;
        }
        int nextTarget = 0;
        int ret = 0;
        if(top.get(start).get(0)!=target){
            nextTarget=top.get(start).get(top.get(start).indexOf(target)-1);
            ret+=movePlate(nextTarget,start,rest[start][end]);
            ret+=movePlate(target,start,end);
            ret+=movePlate(nextTarget,rest[start][end],end);
        }else{
            nextTarget=top.get(end).get()
        }
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        for(int i=0;i<3;i++) top.add(new ArrayList<Integer>());
        for(int i=1;i<=n;i++){
            top.get(0).add(i);
        }
        out.write(movePlate(n,0,2));
        out.newLine();
        out.write(log.toString());
        out.flush();
    }
}