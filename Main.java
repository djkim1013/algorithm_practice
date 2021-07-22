//BOJ: 18870
//2021.07.22
//category: 정렬
//review:
//      - 메모리 초과: 2*10^9 크기의 배열은 너무 크다.
//      - 시간 초과: ArrayList로 중복값 없는 리스트를 선언하고 정렬했지만 시간초과. collection 정렬이 느린것으로 보임
//      - 시간 초과:

import java.io.*;
import java.util.*;

public class Main {
    static int findIndex(int value,int[] arrSort){
        int index=0;
        for(int i=0;i+1<arrSort.length;i++){
            if(value<=arrSort[i]) return index;
            if(arrSort[i]<arrSort[i+1]) index++;
        }
        return index;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] arrSort = arr.clone();
        Arrays.sort(arrSort);
        for(int i:arr){
            out.write(findIndex(i,arrSort)+" ");
        }
        out.flush();
    }
}