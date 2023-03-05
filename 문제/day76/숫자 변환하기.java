import java.util.*;
class Solution {
    class Nm{
        int x;
        int loop;
        public Nm(int x, int loop){
            this.x = x;
            this.loop = loop;
        }
    }
    Map<Integer,Boolean> map = new HashMap<>();
    public int solution(int x, int y, int n) {
        int answer =0;
        answer = bfs(x,y,n);
        return answer;
    }
    private int bfs(int x, int y, int n){
        Queue<Nm> q = new LinkedList<>();
        q.offer(new Nm(x,0));
        while(!q.isEmpty()){
            Nm nm = q.poll();
            if(nm.x == y){
                return nm.loop;
            }
            for(int i=0; i<3; i++){
                int postx = discriminate(nm.x,i,n);
                if(postx <=y && !map.getOrDefault(postx,false)){
                    q.offer(new Nm(postx,nm.loop+1));
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
