import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        for(int i=0; i<cards1.length; i++){
            q1.offer(cards1[i]);
        }
        for(int i=0; i<cards2.length; i++){
            q2.offer(cards2[i]);
        }
        List<String> arr = new ArrayList<>();
        for(int i=0; i<goal.length; i++){
            arr.add(goal[i].equals(q1.peek())? q1.poll() : goal[i].equals(q2.peek())? q2.poll() : "No");
        }
        String answer = "Yes";
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).equals("No")){
                return "No";
            }
        }
        return answer;
    }
}
