import java.util.*;
class Solution {
    class dot{
        int x;
        int y;
        int distance;
        public dot(int x, int y, int distance){
            this.x=x;
            this.y=y;
            this.distance = distance;
        }
    }
    int dx[] = {0,1,0,-1};
    int dy[] = {1,0,-1,0};
    public int solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];
        for(int i=0; i<map.length; i++){
            for(int y=0; y<map[i].length; y++){
                map[i][y] = maps[i].split("")[y];
            }
        }
        int L_loop = 0;
        boolean [][] visit = new boolean[map.length][map[0].length];
        int answer = 0;
        for(int i=0; i<map.length; i++){
            for(int y=0; y<map[i].length; y++){
                if(map[i][y].equals("S")){
                    L_loop = L_bfs(map,i,y);
                }
            }
        }
        int E_loop = 0;
        for(int i=0; i<map.length; i++){
            for(int y=0; y<map[i].length; y++){
                if(map[i][y].equals("L")){
                    E_loop += E_bfs(map,i,y);
                }
            }
        }
        if(L_loop == -1 || E_loop == -1){
            return -1;
        }
        answer += L_loop + E_loop;
        return answer;
    }
    private int L_bfs(String[][] map , int x, int y){
        boolean visit [][] =new boolean[map.length][map[0].length];
        visit[x][y] = true;
        Queue<dot> q = new LinkedList<>();
        int distance = 0;
        q.offer(new dot(x,y,1));
        while(!q.isEmpty()){
            dot d = q.poll();
            for(int i=0; i<4; i++){
                int postx = d.x+dx[i];
                int posty = d.y+dy[i];
                if(postx >=0 && postx < map.length && posty >=0 && posty < map[0].length){
                    if(map[postx][posty].equals("L"))
                        return d.distance;
                    if(!map[postx][posty].equals("X") && !visit[postx][posty]){
                        visit[postx][posty] = true;
                        q.offer(new dot(postx,posty,d.distance+1));
                    }
                }
            }
        }
        return -1;
    }
    private int E_bfs(String[][] map , int x, int y){
        boolean visit [][] =new boolean[map.length][map[0].length];
        visit[x][y] = true;
        Queue<dot> q = new LinkedList<>();
        int distance = 0;
        q.offer(new dot(x,y,1));
        while(!q.isEmpty()){
            dot d = q.poll();
            for(int i=0; i<4; i++){
                int postx = d.x+dx[i];
                int posty = d.y+dy[i];
                if(postx >=0 && postx < map.length && posty >=0 && posty < map[0].length){
                    if(map[postx][posty].equals("E"))
                        return d.distance;
                    if(!map[postx][posty].equals("X") && !visit[postx][posty]){
                        visit[postx][posty] = true;
                        q.offer(new dot(postx,posty,d.distance+1));
                    }
                }
            }
        }
        return -1;
    }
}
