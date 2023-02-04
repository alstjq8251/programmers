import java.util.*;
import java.time.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Map <Integer,String> map = new HashMap<>();
        Arrays.sort(book_time, (o1,o2) -> {return o1[0].compareTo(o2[0]);});
        map.put(0,book_time[0][1]);
        LocalDateTime differ;
        LocalDateTime roomtime;
        int roomindex = 1;
        for(int i=1; i<book_time.length; i++){
            boolean visit = false;
            differ = LocalDateTime.of(2022,1,1,0,0);
            differ = differ.plusHours(Integer.parseInt(book_time[i][0].split(":")[0])).plusMinutes(Integer.parseInt(book_time[i][0].split(":")[1]));
            List<Integer> keyList = new ArrayList<>(map.keySet());
            keyList.sort((s1, s2) -> map.get(s1).compareTo(map.get(s2)));
            for(int y=0; y<keyList.size(); y++){
                String outTime = map.get(keyList.get(y));
                roomtime = LocalDateTime.of(2022,1,1,0,0);
                roomtime = roomtime.plusHours(Integer.parseInt(outTime.split(":")[0])).plusMinutes(Integer.parseInt(outTime.split(":")[1])).plusMinutes(10);
                if(!differ.isBefore(roomtime)){
                    map.put(keyList.get(y),book_time[i][1]);
                    visit = true;
                    break;
                }
            }
            if(!visit){
                map.put(roomindex,book_time[i][1]);
                roomindex++;
            }
        }
        answer = map.size();
        return answer;
    }
}
