//AOJ: JOSEPHUS
//2021.08.21
//category: 선형자료구조
//review:

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
            LinkedList<Integer> soldiers = new LinkedList<Integer>();
            for(int i=0;i<n;i++){
                soldiers.add(i);
            }
            for(int i=0;soldiers.size()>2;i=(i+k)%soldiers.size()){
                soldiers.remove(i);
            }
            System.out.println(soldiers.get(0)+" "+soldiers.get(1));
        }
	}
}
