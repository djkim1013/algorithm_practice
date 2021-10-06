//BOJ: 11399
//2021.10.06
//category: 그리디 알고리즘
//review:
//      - 결과를 내는 법칙이 있는지 먼저 알아낸다.

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum=arr[0];
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
