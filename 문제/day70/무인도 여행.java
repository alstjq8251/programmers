import java.util.*;
class Solution {
    boolean[][] visit;
    class dot{
        int x;
        int y;
        int distance;
        public dot(int x, int y, int distance){
            this.x =x;
            this.y= y;
            this.distance = distance;
        }
    }
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    List<Integer> arr = new ArrayList<>();
    public int[] solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int y=0; y<maps[i].length(); y++){
                map[i][y] = maps[i].split("")[y];
            }
        }
        visit = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<map.length; i++){
            for(int y=0; y<map[i].length; y++){
                if(!visit[i][y] && !map[i][y].equals("X")){
                    visit[i][y] = true;
                    int sum = bfs(map,i,y);
                    arr.add(sum);
                }
            }
        }
        
        Collections.sort(arr);
        if(arr.size() == 0)
            arr.add(-1);
        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
    private int bfs(String[][] maps , int x, int y){
        Queue<dot> queue = new LinkedList<>();
        queue.offer(new dot(x,y, Integer.parseInt(maps[x][y])));
        int sum=0;
        while(!queue.isEmpty()){
            dot d = queue.poll();
            
            sum += d.distance;
            for(int i=0; i<4; i++){
                int postx = d.x+dx[i];
                int posty = d.y+dy[i];
                if(postx >= 0 && postx < maps.length && posty >=0 && posty< maps[x].length){
                    if(!visit[postx][posty] && !maps[postx][posty].equals("X")){
                        visit[postx][posty]=true;
                        queue.offer(new dot(postx,posty,Integer.parseInt(maps[postx][posty])));
                    }
                }
            }
        }
        return sum;
        // if(!visit[x][y] && !maps[x][y].equals("X")){
        //     for(int i=0; i<2; i++){
        //         int postx = x + dx[i];
        //         int posty = y + dy[i];
        //         if(postx<maps.length && posty < maps[x].length){
        //             visit[postx][posty]=true;
        //             sum += Integer.parseInt(maps[x][y]);  
        //             dfs(maps,postx,posty,sum);
        //         }
        //     }
        // }
        // if(sum != 0)
        //     arr.add(sum);
    }
}
