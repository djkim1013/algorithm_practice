//AOJ: boards
//2021.08.21
//category: 선형자료구조
//review:
//      - "스위핑 알고리즘"

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        for(int t=0;t<test;t++){
            int n=Integer.parseInt(br.readLine());
            int[] boards=new int[n+1];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                boards[i]=Integer.parseInt(st.nextToken());
            }
            Stack<Integer> fence = new Stack<Integer>();
            int answer=0;
            for(int i=0;i<n;i++){
                while(!fence.empty()&&boards[fence.peek()]>=boards[i]){
                    int j=fence.peek();
                    fence.pop();
                    int width=-1;
                    if(fence.empty()){
                        width=i;
                    }else{
                        width=i-fence.peek()-1;
                    }
                    answer=Math.max(answer,boards[j]*width);
                }
                fence.push(i);
            }
            System.out.println(answer);
        }
	}
}