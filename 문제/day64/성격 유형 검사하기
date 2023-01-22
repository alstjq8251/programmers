import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=65; i<85; i++){
            map.put(String.valueOf((char)i),0);
        }
        
        for(int i=0; i<survey.length; i++){
            if(choices[i] <=3){
                if(choices[i] == 1){
                    choices[i] =3;
                }else if(choices[i] == 3){
                    choices[i] =1;
                }
                map.put(survey[i].split("")[0],map.getOrDefault(survey[i].split("")[0],0)+choices[i]);           
            }else if(choices[i] >=5){
                map.put(survey[i].split("")[1],map.getOrDefault(survey[i].split("")[1],0)+(choices[i]-4));
            }
        }
        sb.append(map.get("R") > map.get("T") ? "R" : map.get("R") < map.get("T") ? "T" : "R".compareTo("T")>0 ? "T" : "R");
        sb.append(map.get("C") > map.get("F") ? "C" : map.get("C") < map.get("F") ? "F" : "C".compareTo("F")>0 ? "F" : "C");
        sb.append(map.get("J") > map.get("M") ? "J" : map.get("J") < map.get("M") ? "M" : "J".compareTo("M")>0 ? "M" : "J");
        sb.append(map.get("A") > map.get("N") ? "A" : map.get("A") < map.get("N") ? "N" : "A".compareTo("N")>0 ? "N" : "A");
        String answer = sb.toString();
        return answer;
    }
}
