import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        String[] answer = new String[n];
        for(int i=0; i<arr1.length; i++){
            sb.append(Integer.toBinaryString(arr1[i]|arr2[i]));
            while(sb.length() <n){
                sb.insert(0,0);
            }
            for(int y=0; y<sb.length(); y++){
                if(sb.charAt(y)-'0' == 1){
                    sb1.append('#');
                }else{
                    sb1.append(" ");
                }
            }
            answer[i] = sb1.toString();
            sb.setLength(0);
            sb1.setLength(0);
        }
        return answer;
    }
}
