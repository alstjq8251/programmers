import java.util.*;
class Solution {
    public int solution(String s) {
        int s_length = s.length();
        StringBuilder sb =new StringBuilder();
        int answer= 0;
        String next="";
        for(int i=1; i<=s.length()/2; i++){
            int loop = 1;
            String tmp = s.substring(0,i);
            sb.setLength(0);
            for(int y=i; y<s.length(); y += i){
                if(y+i > s.length()){
                    sb.append(s.substring(y));
                    break;
                }
                next = s.substring(y,y+i);
                if(tmp.equals(next)){
                    loop++;
                }else{
                    sb.append(repeatTmp(loop,tmp));
                    tmp = next;
                    loop =1;
                }
            }
            sb.append(repeatTmp(loop,tmp));
            
            s_length = Math.min(s_length,sb.length());
        }
        answer = s_length;
        return answer;
    }
    private String repeatTmp(int loop, String tmp){
        return loop>1 ? loop + ""+tmp : tmp;
    }
}
