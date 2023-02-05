import java.util.*;
import java.time.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        int arraylength =0;
        for(int i=0; i<terms.length; i++){
            map.put(terms[i].split(" ")[0],Integer.parseInt(terms[i].split(" ")[1]));
        }
        LocalDate todayTime = LocalDate.of(Integer.parseInt(today.split("\\.")[0]),Integer.parseInt(today.split("\\.")[1]), Integer.parseInt(today.split("\\.")[2]));
        LocalDate targetTime;
        int year;
        int month;
        for(int i=0; i<privacies.length; i++){
            targetTime = LocalDate.of(Integer.parseInt(privacies[i].split("\\.")[0]),Integer.parseInt(privacies[i].split("\\.")[1]),Integer.parseInt(privacies[i].split("\\.")[2].split(" ")[0]));
            targetTime = targetTime.plusMonths(map.get(privacies[i].split("\\.")[2].split(" ")[1]));
            if(targetTime.getDayOfMonth() == 1){
                targetTime = targetTime.minusMonths(1);
                targetTime = targetTime.withDayOfMonth(28);
            }else{
                targetTime = targetTime.minusDays(1);
            }     
            if(todayTime.isAfter(targetTime)){
                arr.add(i+1);
            }
        }
        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
