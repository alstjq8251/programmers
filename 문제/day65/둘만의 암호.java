import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> map = new HashMap<>();
        for(int i=0; i<skip.length(); i++){
            map.put((int)skip.charAt(i),"char");
        }
        for(int i=0; i<s.length(); i++){
            int differ = index;
            int f_index = (int)s.charAt(i);
            while(differ --> 0){
                f_index ++;
                if(f_index > 122){
                    f_index -=26;
                }
                if(map.containsKey(f_index)){
                    differ++;
                }
            }
            sb.append((char)f_index);
        }
        answer = sb.toString();
        return answer;
    }
}
