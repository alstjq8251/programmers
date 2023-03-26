import java.util.*;
class Solution {
    class park{
        int x;
        int y;
        int loop;
        public park(int x, int y, int loop){
            this.x=x;
            this.y=y;
            this.loop = loop;
        }
    }
    
    int dx[] = {1,0,-1,0};
    int dy[] = {0,1,0,-1};
    
    String[][] road;
    public int[] solution(String[] park, String[] routes) {
        road = new String[park.length][park[0].length()];
        int Location[]= new int[2];
        for(int i=0; i<park.length; i++){
            for(int y=0; y<park[i].length(); y++){
                road[i][y] = park[i].split("")[y];
                if(park[i].split("")[y].equals("S")){
                    Location[0] = i;
                    Location[1] = y;
                }
                    
            }
        }
        for(int i=0; i<routes.length; i++){
            Location = move(Location[0],Location[1],routes[i]);
        }
        int[] answer = Location;
        return answer;
    }
    
    private int[] move(int x, int y, String routes){
        String direction = routes.split(" ")[0];
        int moving = Integer.parseInt(routes.split(" ")[1]);
        Queue<park> q = new LinkedList<>();
        q.offer(new park(x,y,0));
        park p = new park(0,0,0);
        while(!q.isEmpty()){
            p = q.poll();
            if(p.loop == moving)
                break;
            int postx = p.x + dx[checkDirect(direction)];
            int posty = p.y + dy[checkDirect(direction)];
            if(postx >= 0 && postx < road.length && posty >= 0 && posty< road[0].length){
                if(road[postx][posty].equals("O") || road[postx][posty].equals("S")){
                    q.offer(new park(postx,posty,p.loop+1));  
                }else{
                    return new int []{x,y};   
                }  
            }else{
                return new int []{x,y};
            }
        }
        return new int[]{p.x,p.y};
    }
    private int checkDirect(String direct){
        switch(direct){
            case "S": return 0;
            case "E": return 1;
            case "N": return 2;
            case "W": return 3;
            default: return 0;
        }
    }
}
