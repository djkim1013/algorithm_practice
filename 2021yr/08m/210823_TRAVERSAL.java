//AOJ: TRAVERSAL
//2021.08.23
//category: 트리 구현/순회
//review:

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> preorder, inorder, postorder;
    static void getPostOrder(int preStart,int preEnd,int inStart,int inEnd){
        if(preStart==preEnd) return;
        int root=inorder.indexOf(preorder.get(preStart));
        int left=root-inStart;
        getPostOrder(preStart+1,preStart+1+left,inStart,root);
        getPostOrder(preStart+1+left,preEnd,root+1,inEnd);
        postorder.add(preorder.get(preStart));
    }
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseN = Integer.parseInt(br.readLine());
        for(int c=0;c<caseN;c++){
            int n = Integer.parseInt(br.readLine());
            preorder=new ArrayList<Integer>();
            StringTokenizer input = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                preorder.add(Integer.parseInt(input.nextToken()));
            }
            inorder=new ArrayList<Integer>();
            input = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                inorder.add(Integer.parseInt(input.nextToken()));
            }
            postorder=new ArrayList<Integer>();
            getPostOrder(0,n,0,n);
            for(Integer i:postorder){
                bw.write(i+" ");
            }
            bw.newLine();
        }
        bw.flush();
	}
}