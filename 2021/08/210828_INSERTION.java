//AOJ: INSERTION
//2021.08.28
//category: 이진검색트리
//review:
//      -treat: tree+heap ~ 비교적 구현이 쉬운 편이니 숙지할것

import java.util.*;
import java.io.*;

class Node{
    int key;
    double priority;
    int size;
    Node right, left;
    public Node(int key){
        this.key=key;
        priority=Math.random();
        size=1;
    }
    void setRight(Node right){
        this.right=right;
        calSize();
    }
    void setLeft(Node left){
        this.left=left;
        calSize();
    }
    void calSize(){
        size=1;
        if(right!=null) size+=right.size;
        if(left!=null) size+=left.size;
    }
}

public class Main {
    static Node[] split(Node root, int key){
        if(root==null) return new Node[]{null,null};
        if(root.key<key){
            Node[] rs=split(root.right,key);
            root.setRight(rs[0]);
            return new Node[]{root,rs[1]};
        }
        Node[] ls=split(root.left,key);
        root.setLeft(ls[1]);
        return new Node[]{ls[0],root};
    }
    static Node addNode(Node root, Node node){
        if(root==null) return node;
        if(root.priority<node.priority){
            Node[] splitted=split(root,node.key);
            node.setLeft(splitted[0]);
            node.setRight(splitted[1]);
            return node;
        }else if(root.key>node.key){
            root.setLeft(addNode(root.left,node));
        }else{
            root.setRight(addNode(root.right,node));
        }
        return root;
    }
    static Node merge(Node a,Node b){
        if(a==null) return b;
        if(b==null) return a;
        if(a.priority<b.priority){
            b.setLeft(merge(a,b.left));
            return b;
        }
        a.setRight(merge(a.right,b));
        return a;
    }
    static Node removeNode(Node root,int key){
        if(root==null) return root;
        if(root.key==key){
            Node ret=merge(root.left,root.right);
            root=null;
            return ret;
        }
        if(key<root.key){
            root.setLeft((removeNode(root.left,key)));
        }else{
            root.setRight((removeNode(root.right,key)));
        }
        return root;
    }
    static Node kth(Node root,int k){
        int leftSize=0;
        if(root.left!=null) leftSize=root.left.size;
        if(k<=leftSize) return kth(root.left,k);
        if(k==leftSize+1) return root;
        return kth(root.right,k-leftSize-1);
    }
    // static int countOrder(Node root,int key){
    //     if(root==null) return 0;
    //     if(root.key>=key) return countOrder(root.left,key);
    //     int ls=(root.left!=null)?root.left.size:0;
    //     return ls+1+countOrder(root.right,key);
    // }
    //for test
    // static void showTreat(Node root){
    //     if(root.left!=null) showTreat(root.left);
    //     System.out.print(root.key+" ");
    //     if(root.right!=null) showTreat(root.right);
    // }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        while(c-->0){
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] log=new int[n];
            for(int i=0;i<n;i++){
                log[i]=Integer.parseInt(st.nextToken());
            }
            Node treat=null;
            for(int i=1;i<=n;i++){
                treat=addNode(treat,new Node(i));
            }
            StringBuilder answer=new StringBuilder();
            for(int i=n-1;i>=0;i--){
                int target=kth(treat,n---log[i]).key;
                treat=removeNode(treat,target);
                answer.insert(0,target+" ");
            }
            System.out.println(answer);
        }
    }
}
