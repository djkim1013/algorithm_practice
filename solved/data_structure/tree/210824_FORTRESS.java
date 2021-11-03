//AOJ: FORTRESS
//2021.08.24
//category: 트리 구현/순회
//review:
//      - 알고리즘에 필요한 함수를 차근차근 나열하고 구현하자

import java.util.*;
import java.io.*;

public class Main {
    static int[][] walls=new int[100][3];
    static int n, intest;
    class Node{
        int idx;
        List<Node> children = new ArrayList<Node>();
    }

    Node getTree(int idx){
        Node tree = new Node();
        tree.idx = idx;
        for(int ch=0;ch<n;ch++){
            if(isChild(idx,ch)) tree.children.add(getTree(ch));
        }
        return tree;
    }

    boolean isChild(int parent, int child){
        if(!enclose(parent,child)) return false;
        for(int i=0;i<n;i++){
            if(i!=parent&&i!=child&&
                enclose(parent,i)&&enclose(i,child)){
                return false;
            }
        }
        return true;
    }

    boolean enclose(int a, int b){
        if(walls[a][2]<=walls[b][2]) return false;
        int dxSqr=walls[a][0]-walls[b][0];
        dxSqr*=dxSqr;
        int dySqr=walls[a][1]-walls[b][1];
        dySqr*=dySqr;
        int drSqr=walls[a][2]-walls[b][2];
        drSqr*=drSqr;
        return dxSqr+dySqr<drSqr;
    }
    
    int height(Node root){
        List<Integer> heights = new ArrayList<Integer>();
        for(int i=0;i<root.children.size();i++){
            heights.add(height(root.children.get(i)));
        }
        if(heights.isEmpty()) return 0;
        Collections.sort(heights);
        if(heights.size()>=2){
            intest=Math.max(intest,
                2+heights.get(heights.size()-2)+heights.get(heights.size()-1));
        }
        return heights.get(heights.size()-1)+1;
    }

    int solve(Node root){
        intest=0;
        int h=height(root);
        return Math.max(intest,h);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseN = Integer.parseInt(br.readLine());
        Main m = new Main();
        for(int c=0;c<caseN;c++){
            n = Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                StringTokenizer input = new StringTokenizer(br.readLine());
                for(int j=0;j<3;j++){
                    walls[i][j]=Integer.parseInt(input.nextToken());
                }
            }
            Node root=m.getTree(0);
            System.out.println(m.solve(root));
        }
    }
}