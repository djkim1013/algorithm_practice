//BOJ: 18870
//2021.07.22
//category: 정렬
//review:
//      - 메모리 초과: 2*10^9 크기의 배열은 너무 크다.
//      - 시간 초과

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        int[] arr = new int[n];
        ArrayList<Integer> arrSort = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(!arrSort.contains(arr[i])) arrSort.add(arr[i]);
        }
        Collections.sort(arrSort);
        for(int i:arr){
            out.write(arrSort.indexOf(i)+" ");
        }
        out.flush();
    }
}