//AOJ DRAWRECT
//2021.10.22
//category: 
//review:

import java.io.*;
import java.util.*;

class Main{
  public static void main(String[] args)throws Exception{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int n=Integer.parseInt(br.readLine());
	StringBuilder answer=new StringBuilder();
	int[][] points=new int[3][2];
	StringTokenizer st;
	while(n-->0){
	  for(int i=0;i<3;i++){
		st=new StringTokenizer(br.readLine());
		points[i][0]=Integer.parseInt(st.nextToken());
		points[i][1]=Integer.parseInt(st.nextToken());
	  }
	  if(points[0][0]==points[1][0])
		answer.append(points[2][0]);
	  else if(points[0][0]==points[2][0])
		answer.append(points[1][0]);
	  else
		answer.append(points[0][0]);
	  answer.append(" ");
	  if(points[0][1]==points[1][1])
		answer.append(points[2][1]);
	  else if(points[0][1]==points[2][1])
		answer.append(points[1][1]);
	  else
		answer.append(points[0][1]);
	  answer.append("\n");
	}
	System.out.print(answer);
  }
}