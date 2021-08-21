//AOJ: JOSEPHUS
//2021.08.21
//category: 선형자료구조
//review:
//      - 큐를 이용해 풀어보기
//      - 큐 내부에서 순서를 바꿨으므로 오름차순 정렬이 되어있지 않다.

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for(int t = 0; t < test; t++){
            String input = br.readLine();
            int n = Integer.parseInt(input.substring(0, input.indexOf(" ")));
            int k = Integer.parseInt(input.substring(input.indexOf(" ")+1));
            Queue<Integer> soldiers = new LinkedList<Integer>();
            for(int i=1;i<=n;i++){
                soldiers.add(i);
            }
            while(soldiers.size()>2){
                soldiers.remove();
                for(int i=0;i+1<k;i++){
                    int swap = soldiers.poll();
                    soldiers.add(swap);
                }
            }
            int answer1 = soldiers.poll();
            int answer2 = soldiers.poll();
            if(answer1>answer2){
                System.out.println(answer2+" "+answer1);
            }else{
                System.out.println(answer1+" "+answer2);
            }
        }
	}
}
