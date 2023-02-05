import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tube = new StringBuilder();
        int order =1;
        int i = 0;
        while(true){
            sb.append(Integer.toString(i,n));
            for(int y=0; y<sb.length(); y++){
                if(order == p){
                    if(sb.charAt(y)- '0' >= 0 && sb.charAt(y)-'0' < 10){
                        tube.append(sb.charAt(y));
                    }else{
                        int index = (int)sb.charAt(y) - 32;
                        tube.append((char)index);
                    }
                }
                if(tube.length() >=t)
                    break;
                order++;
                if(order > m)
                    order = 1;
            }
            if(tube.length() >=t)
                break;
            sb.setLength(0);
            i++;
        }
        String answer = tube.toString();
        return answer;
    }
}
