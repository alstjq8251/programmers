import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> headMap = new HashMap<>();
        Map<Integer,String> numMap = new HashMap<>();
        Map<Integer,String> tailMap = new HashMap<>();
        String[] answer = new String[files.length];
        for(int i=0; i<files.length; i++){
            int order = 1;
            int index = 0;
            for (; index < files[i].length(); index ++){
                if(files[i].charAt(index) - '0'>= 0 && files[i].charAt(index) - '0'< 10)
                    break;
                else
                    sb.append(files[i].charAt(index));
            }
            headMap.put(i,sb.toString());
            sb.setLength(0);
            for(; index < files[i].length(); index ++){
                if(!(files[i].charAt(index) - '0'>= 0 && files[i].charAt(index) - '0'< 10))
                    break;
                else if(sb.length() >=5){
                    break;
                }else
                    sb.append(files[i].charAt(index));
            }
            numMap.put(i,sb.toString());
            sb.setLength(0);
            for(; index< files[i].length(); index++){
                sb.append(files[i].charAt(index));
            }
            tailMap.put(i,sb.toString());
            sb.setLength(0);
        }
        List<Integer> prekey = new ArrayList<>(headMap.keySet());
        List<Integer> postkey = new ArrayList<>(headMap.keySet());
        Collections.sort(postkey,(s1,s2)->headMap.get(s1).toLowerCase().compareTo(headMap.get(s2).toLowerCase()));
        // Collections.sort(postkey,(s1,s2)->{
        //     int value = headMap.get(s1).toLowerCase().compareTo(headMap.get(s2).toLowerCase());
        //     if(value == 0){
        //         return Integer.parseInt(numMap.get(s1))- Integer.parseInt(numMap.get(s2));
        //     }else{
        //         return value;
        //     }
        // });
        // for(int i=0; i<postkey.size(); i++){
        //     sb.append(headMap.get(postkey.get(i))+numMap.get(postkey.get(i))+tailMap.get(postkey.get(i)));
        //     answer[i]= sb.toString();
        //     sb.setLength(0);
        // }
            
        List<Integer> sameHead = new ArrayList<>();
        List<Integer> preNum;
        List<Integer> postNum;
        int answerIndex = 0;
        for(int i=0; i<prekey.size(); i++){
            if(sameHead.size() == 0){
                sameHead.add(postkey.get(i));
            }else{
                if(!headMap.get(sameHead.get(sameHead.size()-1)).toLowerCase().equals(headMap.get(postkey.get(i)).toLowerCase())){
                    Collections.sort(sameHead,(s1,s2)->Integer.parseInt(numMap.get(s1))-Integer.parseInt(numMap.get(s2)));
                    for(int y=0; y<sameHead.size(); y++){
                        if(tailMap.containsKey(sameHead.get(y))){
                            sb.append(headMap.get(sameHead.get(y))+numMap.get(sameHead.get(y))+tailMap.get(sameHead.get(y)));
                            answer[answerIndex++] = sb.toString();
                            sb.setLength(0);
                        }else{
                            sb.append(headMap.get(sameHead.get(y))+numMap.get(sameHead.get(y)));
                            answer[answerIndex++] = sb.toString();
                            sb.setLength(0);
                        }
                    }
                    for(int y=0; y<sameHead.size(); y++){
                        numMap.remove(sameHead.get(y));
                        tailMap.remove(sameHead.get(y));
                    }
                    sameHead.clear();
                    sameHead.add(postkey.get(i));
                }else{
                    sameHead.add(postkey.get(i));
                }
            }
        }
        if(sameHead.size() != 0){
            postNum = new ArrayList<>(numMap.keySet());
            Collections.sort(postNum,(s1,s2)->Integer.parseInt(numMap.get(s1))-Integer.parseInt(numMap.get(s2)));
            for(int i=0; i<postNum.size(); i++){
                if(tailMap.containsKey(postNum.get(i))){
                    sb.append(headMap.get(postNum.get(i))+numMap.get(postNum.get(i))+tailMap.get(postNum.get(i)));
                }else{
                    sb.append(headMap.get(postNum.get(i))+numMap.get(postNum.get(i)));
                }
                answer[answerIndex++] = sb.toString();
                sb.setLength(0);
            }
        }
        return answer;
    }
}

// 위에 주석해놓은 람다를 비롯한 head, num동시 정렬과 밑은 같지만 밑에잇는 정렬은 head를 먼저 정렬하고 그 head를 기준으로 비교해서 num을 정렬함
// 꽤 오랫동안 틀렸는데 그 이유는 head , num 따로 정렬할 당시 head의 index가 바뀌는걸 따로 처리하는 등 조건이 잘못되서 그랬다
