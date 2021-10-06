//BOJ: 13305
//2021.10.06
//category: 그리디 알고리즘
//review:

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lengths=new int[n-1];
        int[] prices=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n-1;i++){
            lengths[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            prices[i]=Integer.parseInt(st.nextToken());
        }
        int minPrice=prices[0];
        int minSum=0;
        for(int i=0;i<n-1;i++){
            minSum+=minPrice*lengths[i];
            minPrice=Math.min(minPrice,prices[i+1]);
        }
        System.out.println(minSum);
    }
}
