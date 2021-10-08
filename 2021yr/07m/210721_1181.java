//BOJ: 1181
//2021.07.21
//category: 정렬
//review:

import java.io.*;
import java.util.*;

public class Main {
    
    static public class Vocabulary implements Comparable<Vocabulary>{
        String str;
        Integer len;
        public Vocabulary(String str){
            this.str=str;
            this.len=str.length();
        }
        public int compareTo(Vocabulary other){
            if(len.compareTo(other.len)==0) return str.compareTo(other.str);
            return len.compareTo(other.len);

        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        Vocabulary[] arr = new Vocabulary[n];
        for(int i=0;i<n;i++){
            String str = in.readLine();
            arr[i]=new Vocabulary(str);
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i>0&&arr[i-1].str.equals(arr[i].str))continue;
            out.write(arr[i].str);
            out.newLine();
        }
        out.flush();
    }
}