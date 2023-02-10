import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<answer.length; i++){
            answer[i] = -1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        ArrayList<Integer> indexes;
        ArrayList<Integer> tmp_index;
        for(int i=0; i<numbers.length; i++){
            if(q.size() > 0){
                while(q.peek() < numbers[i]){
                    if(map.containsKey(q.peek())){
                        tmp_index = map.get(q.peek());
                        for(int z=0; z<tmp_index.size(); z++){
                            answer[tmp_index.get(z)] = numbers[i];
                        }                   
                    }
                    map.remove(q.poll());

                    if(q.size() == 0)
                        break;     
                }
            }
            indexes = map.getOrDefault(numbers[i], new ArrayList<>());
            indexes.add(i);
            q.offer(numbers[i]);
            map.put(numbers[i],indexes);
        }
        return answer;
    }
}
