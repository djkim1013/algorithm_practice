//AOJ: NERD2
//2021.08.26
//category: 이진검색트리
//review:

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseN = Integer.parseInt(br.readLine());
        int n, answer, p, q;
        TreeMap<Integer,Integer> tree;
        StringTokenizer input;
        Integer ceil, out;
        for(int c=0;c<caseN;c++){
            answer = 0;
            n = Integer.parseInt(br.readLine());
            tree = new TreeMap<Integer,Integer>();
            for(int i=0;i<n;i++){
                input = new StringTokenizer(br.readLine()," ");
                p=Integer.parseInt(input.nextToken());
                q=Integer.parseInt(input.nextToken());
                ceil=tree.ceilingKey(p);
                if(ceil==null||tree.get(ceil)<q){
                    tree.put(p, q);
                    out=tree.lowerKey(p);
                    while(out!=null){
                        if(tree.get(out)<=q) tree.remove(out);
                        out=tree.lowerKey(out);
                    }
                }
                answer+=tree.size();
            }
            bw.write(answer+"\n");
        }
        bw.flush();
    }
}
