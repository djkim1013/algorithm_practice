//AOJ: FORTRESS
//2021.08.23
//category: 트리 구현/순회
//review:

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseN = Integer.parseInt(br.readLine());
        for(int c=0;c<caseN;c++){
            int n = Integer.parseInt(br.readLine());
            int[][] walls = new int[n][3];
            for(int i=0;i<n;i++){
                StringTokenizer input = new StringTokenizer(br.readLine());
                for(int j=0;j<3;j++){
                    walls[i][j]=Integer.parseInt(input.nextToken());
                }
            }
            ArrayList<Integer> nodes=new ArrayList<Integer>();
            nodes.add(0);
            for(int i=1;i<n;i++){
                int[] a=walls[i];
                for(int j=0;j<i;j++){
                    if(!include(walls[j],a)){
                        
                    }
                }
            }
        }
    }
}