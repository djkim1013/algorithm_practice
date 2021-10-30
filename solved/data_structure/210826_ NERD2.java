//AOJ: NERD2
//2021.08.26
//category: 이진검색트리
//review:
//      - treeMap.headMap 을 사용하면 오류가 발생한다. 원인을 모르겠음
//      - timeover: 새로 추가된 점의 왼쪽에 지배되지 않는 점이 발견되면 그 시점에서 검사를 중단한다.

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        while(c-->0){
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
            for(int i=0;i<n;i++){
                StringTokenizer input = new StringTokenizer(br.readLine()," ");
                int p=Integer.parseInt(input.nextToken());
                int q=Integer.parseInt(input.nextToken());
                tree.put(p, q);
                Integer ceil=tree.higherKey(p);
                if(ceil!=null&&tree.get(ceil)>q){
                    tree.remove(p);
                }else{
                    Integer out=tree.lowerKey(p);
                    while(out!=null){
                        if(tree.get(out)<=q){
                            tree.remove(out);
                            out=tree.lowerKey(out);
                        }else{
                            out=null;
                        }
                    }
                }
                answer+=tree.size();
            }
            System.out.println(answer);
        }
    }
}
