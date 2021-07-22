//BOJ: 18870
//2021.07.22
//category: 정렬
//review:
//      - 메모리 초과: 2*10^9 크기의 배열은 너무 크다.
//      - 시간 초과: 순위를 선형검색하면 너무 느리다.
//          -> hashmap 사용으로 해결
//          -> 다른풀이: 이진탐색으로 해결

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            
        }
        int[] arrSort=arr.clone();
        Arrays.sort(arrSort);
        HashMap<Integer,Integer> rank = new HashMap<Integer,Integer>();
        // rank.put(arrSort[0],0);
        int count=0;
        for(int i=0;i<n;i++){
            // if(arrSort[i]>arrSort[i-1]){
            if(!rank.containsKey(arrSort[i])){
                rank.put(arrSort[i],count++);
            }
        }
        for(int i:arr){
            out.write(rank.get(i)+" ");
        }
        out.flush();
    }
}