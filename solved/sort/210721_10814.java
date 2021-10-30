//BOJ: 10814
//2021.07.21
//category: 정렬
//review:
//      - 문제 오독: 나이가 같으면 이름순 정렬이 아니라 가입일 순 정렬이다.

import java.io.*;
import java.util.*;

public class Main {
    
    static public class User implements Comparable<User>{
        Integer index;
        Integer age;
        String name;
        public User(int index,int age,String name){
            this.index=index;
            this.age=age;
            this.name=name;
        }
        public int compareTo(User other){
            if(age.compareTo(other.age)==0) return index.compareTo(other.index);
            return age.compareTo(other.age);

        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        User[] arr = new User[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i]=new User(i,age,name);
        }
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            out.write(arr[i].age+" "+arr[i].name);
            out.newLine();
        }
        out.flush();
    }
}