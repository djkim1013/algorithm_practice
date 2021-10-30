//2021 APC - C
//2021.10.30
//category: 
//review:

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] pages=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) pages[i]=Integer.parseInt(st.nextToken());
        int now=0;
        Deque<Integer> backward=new LinkedList<Integer>();
        Deque<Integer> frontward=new LinkedList<Integer>();
        while(q-->0){
            String input=br.readLine();
            switch(input.charAt(0)){
                case 'B' :{
                    if(!backward.isEmpty()){
                        frontward.addLast(now);
                        now=backward.pollLast();
                    }
                    break;
                }
                case 'F' :{
                    if(!frontward.isEmpty()){
                        backward.addLast(now);
                        now=frontward.pollLast();
                    }
                    break;
                }
                case 'A' :{
                    while(!frontward.isEmpty()){
                        c+=pages[frontward.pollLast()];
                    }
                    if(now>0) backward.addLast(now);
                    now=Integer.parseInt(input.substring(input.indexOf(" ")+1));
                    c-=pages[now];
                    while(c<0&&!backward.isEmpty()) c+=pages[backward.pollFirst()];
                    break;
                }
                case 'C' :{
                    Deque<Integer> compressed=new LinkedList<Integer>();
                    while(!backward.isEmpty()){
                        int temp=backward.pollLast();
                        if(!compressed.isEmpty()&&temp==compressed.peekFirst())
                            c+=pages[temp];
                        else compressed.addFirst(temp);
                    }
                    backward=compressed;
                    break;
                }
            }
        }
        bw.write(now+"\n");
        if(backward.isEmpty()) bw.write("-1");
        else bw.write(backward.pollLast().toString());
        while(!backward.isEmpty()) bw.write(" "+backward.pollLast());
        bw.newLine();
        if(frontward.isEmpty()) bw.write("-1");
        else bw.write(frontward.pollLast().toString());
        while(!frontward.isEmpty()) bw.write(" "+frontward.pollLast());
        bw.newLine();
        bw.flush();
    }
}
