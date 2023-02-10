import java.util.*;
class Solution{
    
    class Square{
        int startx;
        int starty;
        int endx;
        int endy;
        public Square(int startx, int starty, int endx, int endy){
            this.startx = startx;
            this.starty = starty;
            this.endx = endx;
            this.endy = endy;
        }
    }
    int []dx = {0,1};
    int []dy = {1,0};
    public int solution(int [][]board){
        int max = 0;
        int answer=0;
        for(int i=0; i<board.length; i++){
            for(int y=0; y<board[i].length; y++){
                if(board[i][y] != 0){
                    max = Math.max(max,bfs(board,i,y));
                }
                if((board.length- (i+1))*(board[i].length-(y+1)) <= max)
                    break;
            }
            if(board.length- (i+1) <= (int)Math.sqrt(max))
                break;
        }
        answer = max;
        return answer;
    }
    private int bfs(int[][] board, int x, int y){
        boolean visit[][] = new boolean[board.length][board[x].length];
        visit[x][y] = true;
        Queue<Square> q = new LinkedList<>();
        int sx = 1;
        int sy = 1;
        q.offer(new Square(x,y,x,y));
        Square square;
        int limitx = board.length-1;
        int limity = board[x].length-1;
        while(!q.isEmpty()){
            square = q.poll();
            sx = square.endx - square.startx +1;
            sy = square.endy - square.starty +1;
            for(int i=0; i<2; i++){
                int postx = square.endx+dx[i];
                int posty = square.endy+dy[i];
                if(postx <= limitx && posty <= limity){
                    if(board[postx][posty] != 0 && !visit[postx][posty]){
                        visit[postx][posty] = true;
                        q.offer(new Square(x,y,postx,posty));
                    }else{
                        if(board[postx][posty] == 0){
                            if(postx != square.endx)
                                limitx = square.endx;
                            else
                                limity = square.endy;
                        }
                    }
                }
            }
        }
        sx = Math.min(sx,sy);
        return (int)Math.pow(sx,2);
    }
}
