//AOJ: FENCE
//2021.08.22
//category: 큐/스텍/데크
//review:
//      - "스위핑 알고리즘"
//      -오답: 마지막 판자 체크 누락

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
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
            for(int i=0;i<=n;i++){
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
                fence.add(i);
            }
            bw.write(answer+"\n");
        }
        bw.flush();
	}
}