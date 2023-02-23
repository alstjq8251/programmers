import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            for(int y=0; y<keymap[i].length(); y++){
                int index = map.getOrDefault(keymap[i].split("")[y],y+1);
                index = Math.min(index,y+1);
                map.put(keymap[i].split("")[y],index);
            }
        }
        int[] answer = new int[targets.length];
        for(int i=0; i<targets.length; i++){
            int index =0;
            for(int y=0; y<targets[i].length(); y++){
                if(map.containsKey(targets[i].split("")[y])){
                    index += map.get(targets[i].split("")[y]);
                }
                else {
                    index = -1;
                    break;
                }
            }
            answer[i] = index;
        }
        return answer;
    }
}
