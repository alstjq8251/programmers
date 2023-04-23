import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> name_map = new HashMap<>();
        Map<Integer,String> rank_map = new HashMap<>();
        for(int i=0; i<players.length; i++){
            name_map.put(players[i],i+1);
            rank_map.put(i+1,players[i]);
        }
        
        int pre_rank = 0;
        int post_rank = 0;
        for(int i=0; i<callings.length; i++){
            pre_rank = name_map.get(callings[i]);
            post_rank = pre_rank -1 >= 0 ? pre_rank -1 : 0;
            name_map.put(callings[i],post_rank);
            name_map.put(rank_map.get(post_rank),pre_rank);
            rank_map.put(pre_rank, rank_map.get(post_rank));
            rank_map.put(post_rank, callings[i]);
        }
        
    
        String[] answer = new String[players.length];
        
        
        List<Integer> keys = new ArrayList<>(rank_map.keySet());
        keys.sort((o1,o2)->o1-o2);
        for(int i=0; i<keys.size(); i++){
            answer[i] = rank_map.get(keys.get(i));
        }
        
        return answer;
    }
}
