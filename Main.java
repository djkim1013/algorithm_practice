//BOJ: 1427
//2021.07.21
//category: 정렬
//review:

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();
        Character[] arr = new Character[input.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=input.charAt(i);
        }
        Arrays.sort(arr,Collections.reverseOrder());
        for(Character c:arr){
            out.write(c);
        }
        out.flush();
    }
}