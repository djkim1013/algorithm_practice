//AOJ: NERD2
//2021.08.24
//category: 트리 구현/순회
//review:
//      - 알고리즘에 필요한 함수를 차근차근 나열하고 구현하자

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseN = Integer.parseInt(br.readLine());
        for(int c=0;c<caseN;c++){
            n = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
            for(int i=0;i<n;i++){
                StringTokenizer input = new StringTokenizer(br.readLine());
                int p=Integer.parseInt(input.nextToken());
                int q=Integer.parseInt(input.nextToken());
                tree.put(p, q);
                int ceilQ = tree.get(tree.ceilingKey(p));
                if(ceilQ>=q){
                    tree.remove(p);
                    continue;
                }
                SortedMap<Integer,Integer> underMap = tree.headMap(p);
                for(int key:underMap.keySet()){
                    if(key==p) continue;
                    if(underMap.get(key)<=q){
                        tree.remove(key);
                    }
                }
            }
            System.out.println(tree.size());
        }
    }
}