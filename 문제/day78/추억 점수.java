import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++){
            int score = 0;
            for(int y=0; y<photo[i].length; y++){
                score += map.getOrDefault(photo[i][y],0);
            }
            answer[i] = score;
        }
        return answer;
    }
}
