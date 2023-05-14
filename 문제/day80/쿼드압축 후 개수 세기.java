import java.util.*;
class Solution {
    int []dx = {1,0,-1,0};
    int []dy = {0,1,0,-1};
    class quard{
        int x;
        int y;
        int point;
        public quard(int x, int y, int point){
            this.x=x;
            this.y=y;
            this.point=point;
        }
    }
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        DFS(arr,0,0,arr.length,arr[0].length);
        
        long countOnes = Arrays.stream(arr)
        .flatMapToInt(Arrays::stream)
        .filter(num -> num == 1)
        .count();

        long countZeros = Arrays.stream(arr)
        .flatMapToInt(Arrays::stream)
        .filter(num -> num == 0)
        .count();
        
        answer[0] = (int)countZeros;
        answer[1] = (int)countOnes;

        return answer;
    }
    
    private void DFS(int [][] arr, int x1, int y1, int x2, int y2){
        if(x2-x1 == 1 && y2-y1 == 1)return ;
    
        boolean isSame = bfs(arr,x1,y1,x2,y2);
        
        if(isSame){
            for(int i=x1; i<x2; i++){
                for(int j=y1; j<y2; j++){
                    if(i == x1 && j==y1) continue;
                    arr[i][j] = -1;
                }
            }
        }else{
            int len = (x2-x1)/2;
            
            DFS(arr,x1,y1,x1+len, y1+len);
            DFS(arr,x1+len,y1,x2, y1+len);
            DFS(arr,x1,y1+len,x1+len, y2);
            DFS(arr,x1+len,y1+len,x2, y2);
        }
    }
    
    private boolean bfs(int[][] arr, int x1, int y1, int x2, int y2){
        Queue<quard> q = new LinkedList<>();
        q.offer(new quard(x1,y1,arr[x1][y1]));
        boolean [][] visit = new boolean[arr.length][arr[0].length];
        visit[x1][y1] = true;
        while(!q.isEmpty()){
            quard qu = q.poll();
            for(int i=0; i<4; i++){
                int postx = qu.x + dx[i];
                int posty = qu.y + dy[i];
                if(postx>=x1 && postx <x2 && posty>= y1 && posty<y2){
                    if(!visit[postx][posty]){
                        if(qu.point != arr[postx][posty]){
                            return false;
                        }
                        visit[postx][posty] = true;
                        q.offer(new quard(postx,posty,arr[postx][posty]));
                    }
                }
            }
        }
        return true;
    }
}
