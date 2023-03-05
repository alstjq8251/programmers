import java.util.*;
class Solution {
    class Nm{
        int x;
        int y;
        int loop;
        public Nm(int x, int y, int loop){
            this.x = x;
            this.y = y;
            this.loop = loop;
        }
    }
    Map<Integer,Boolean> map = new HashMap<>();
    public int solution(int x, int y, int n) {
        if(y % x != 0 && y-n <x){
            return -1;
        }
        int answer =0;
        answer = bfs(x,y,n);
        return answer;
    }
    private int bfs(int x, int y, int n){
        Queue<Nm> q = new LinkedList<>();
        q.offer(new Nm(x,y,0));
        while(!q.isEmpty()){
            Nm nm = q.poll();
            if(nm.x == nm.y){
                return nm.loop;
            }else if(nm.x >y){
                break;
            }
            for(int i=0; i<3; i++){
                int postx = discriminate(nm.x,i,n);
                if(postx <=y && !map.getOrDefault(postx,false)){
                    q.offer(new Nm(postx,y,nm.loop+1));
                    map.put(postx,true);
                }
            }
        }
        return -1;
    }
    private int discriminate(int x, int i, int n){
        return i == 0 ? x+n : i == 1 ? x*2 : x*3;
    }
}
