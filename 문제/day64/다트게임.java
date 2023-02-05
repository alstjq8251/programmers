import java.util.*;
class Solution {
    List<Integer> arr = new ArrayList<>();
    public int solution(String dartResult) {
        int answer = 0;
        int loop =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<dartResult.length(); i++){
            if(sb.length() == 0){
                sb.append(dartResult.charAt(i));
                if(dartResult.charAt(i+1) -'0' <10 && dartResult.charAt(i+1) -'0' >= 0){
                    sb.append(dartResult.charAt(i+1));
                    i++;
                }
            }else{
                if(dartResult.charAt(i) -'0' <10 && dartResult.charAt(i) -'0' >= 0){
                    calculate(sb,loop);
                    loop++;
                    sb.setLength(0);
                    if(dartResult.charAt(i+1) -'0' <10 && dartResult.charAt(i+1) -'0' >= 0){
                        sb.append(dartResult.charAt(i)).append(dartResult.charAt(i+1));
                        i++;
                    }else{
                        sb.append(dartResult.charAt(i));
                    }
                }else{
                    sb.append(dartResult.charAt(i));
                }
            }
        }
        calculate(sb,loop);
        for(int i=0; i<arr.size(); i++){
            answer += arr.get(i);
        }
        return answer;
    }
    private void calculate(StringBuilder sb, int loop){
        StringBuilder sb1 = new StringBuilder();
        if(sb.length() <3){
            int number = sb.charAt(0)-'0';
            bonusPoint(number,sb.charAt(1),loop);
        }
        else if(sb.length() <=3){
            if(sb.charAt(1) -'0' <10&& sb.charAt(1) -'0'>=0){
                sb1.append(sb.charAt(0)).append(sb.charAt(1));
                bonusPoint(Integer.parseInt(sb1.toString()),sb.charAt(2),loop);    
            }else{
                int number;
                if(sb.charAt(1) =='S'){
                    number = sb.charAt(0)-'0';
                    checkWord(sb.charAt(2),loop,number);
                }else if(sb.charAt(1) == 'D'){
                    number = (int)Math.pow(sb.charAt(0)-'0',2);
                    checkWord(sb.charAt(2),loop,number);
                }else if(sb.charAt(1) == 'T'){
                    number = (int)Math.pow(sb.charAt(0)-'0',3);
                    checkWord(sb.charAt(2),loop,number);
                }
            }
        }else{
            int number;
            sb1.append(sb.charAt(0)).append(sb.charAt(1));
            if(sb.charAt(2) == 'S'){
                number = Integer.parseInt(sb1.toString());
                checkWord(sb.charAt(3),loop,number);
            }else if(sb.charAt(2) == 'D'){
                number = Integer.parseInt(sb1.toString());
                checkWord(sb.charAt(3),loop,number*2);
            }else{
               number = Integer.parseInt(sb1.toString());
                checkWord(sb.charAt(3),loop,number*3); 
            }
        }
    }
    private void bonusPoint(int number ,char word, int loop){
        if(word =='S'){
            arr.add(loop,number);
        }else if(word == 'D'){
            arr.add(loop,(int)Math.pow(number,2));
        }else if(word == 'T'){
            arr.add(loop,(int)Math.pow(number,3));
        }
    }
    private void checkWord(char word, int loop , int number){
        if(word == '#'){
            number *= -1;
            arr.add(loop,number);
        }else if(word == '*'){
            if(loop == 0){
                arr.add(loop,number*2);
            }else{
                arr.set(loop-1,arr.get(loop-1)*2);
                arr.add(loop,number*2);
            }
        }
    }
}
