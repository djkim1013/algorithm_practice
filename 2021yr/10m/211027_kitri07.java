//코딩테스트 광탈방지 - 07 올바른 괄호의 갯수
//2021.10.27
//category: DFS
//review:

class Solution {
  int dfs(int close,int open){
      if (open==0) return 1;
      int ret=dfs(close,open-1);
      if(close>open) ret+=dfs(close-1,open);
      return ret;
  }
  
  public int solution(int n) {
      return dfs(n,n);
  }
}