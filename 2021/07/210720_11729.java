//BOJ: 11729
//2021.07.20
//category: 재귀함수 구현
//review:
//      - 다중 리스트 사용으로 표기가 복잡해져서 함수 내에서 단일 리스트를 사용
//      - 다른 해답: 실제 이동 구현 없이 이동 규칙만 이용할 수 있다.

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static StringBuilder log = new StringBuilder();
    static ArrayList<ArrayList<Integer>> stack=new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args)throws Exception{
        int n = Integer.parseInt(in.readLine());
        for(int i=0;i<3;i++) stack.add(new ArrayList<Integer>(){{add(n+1);}});
        for(int i=n;i>0;i--){
            stack.get(0).add(0,i);
        }
        // for(Integer i:stack.get(0)){
        //     out.write(i+" ");
        // }
        // out.newLine();
        out.write(movePlate(n,0,2)+"\n");
        out.write(log.toString());
        out.flush();
    }
    static int movePlate(int target,int start,int end)throws Exception{
        ArrayList<Integer> s = stack.get(start);
        ArrayList<Integer> e = stack.get(end);
        if(target == s.get(0)){
            s.remove(0);
            e.add(0,target);
            log.append((start+1)+" "+(end+1)+"\n");
            return 1;
        }
        int nextTarget = s.get(s.indexOf(target)-1);
        int ret = 0;
        ret += movePlate(nextTarget,start,rest(start,end));
        ret += movePlate(target,start,end);
        ret += movePlate(nextTarget,rest(start,end),end);
        return ret;
    }
    static int rest(int start, int end){
        if(start == 0){
            if(end == 1) return 2;
            return 1;
        }
        if(start == 1){
            if(end == 0) return 2;
            return 0;
        }
        if(start == 2){
            if(end == 0) return 1;
            return 0;
        }
        return -1;
    }
}