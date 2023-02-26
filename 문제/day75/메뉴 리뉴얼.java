import java.util.*;
class Solution {
    boolean [] visit;
    Map<String,Integer> map = new HashMap<>();
    Set<Integer> courseSet = new HashSet<>();
    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<course.length; i++){
            courseSet.add(course[i]);
        }
        for(int i=0; i<orders.length; i++){
            visit = new boolean[orders[i].length()];
            for(int y=0; y<course.length; y++){
                Combination(orders[i],visit,0,orders[i].length(),orders[i].length());
            }
            
        }
        System.out.println(map);
        map.entrySet().removeIf(entry->entry.getValue() < 2);
        System.out.println(map);
        List<String> key = new ArrayList<>(map.keySet());
        
        key.sort((o1,o2)->{
            int index = o1.length()-o2.length();
                 if(index == 0){
                     return map.get(o2)-map.get(o1);
                 }
                 return index;});
        System.out.println(key);
        List<String> arr = new ArrayList<>();
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<course.length; i++){
            for(int y=0; y<key.size() -1; y++){
                if(y == key.size()-1){
                    if(arr.get(arr.size()-1)==key.get(key.size()-1)){
                        arr.add(key.get(key.size()-1));
                    }
                }
                if(course[i] == key.get(y).length()){
                    if(map.get(key.get(y)) == map.get(key.get(y+1))){
                        arr.add(key.get(y));
                    }else{
                        arr.add(key.get(y));
                        break;
                    }
                }else
                    break;
            }
            int number = course[i];
            key.removeIf(keys-> keys.length() ==number);
        }
        Collections.sort(arr,(o1,o2)->o1.compareTo(o2));
        String[]answer = new String[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
    private void Combination(String s, boolean[] visit, int start, int n, int r){
        if(r == 0){
            String res = calculate(s,visit,n);
            map.put(res,map.getOrDefault(res,0)+1);
        }
        for(int i=start; i<n; i++){
            visit[i] = true;
            Combination(s,visit,i+1,n,r-1);
            visit[i] = false;
        }
    }
    private String calculate(String s,boolean[] visit, int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(visit[i]){ 
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
