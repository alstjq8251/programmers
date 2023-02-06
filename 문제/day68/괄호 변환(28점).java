import java.util.*;
class Solution {
    StringBuilder sb = new StringBuilder();
    StringBuilder ub = new StringBuilder();
    StringBuilder vb = new StringBuilder();
    StringBuilder postsb = new StringBuilder();
    boolean goldbalance = false;
    public String solution(String p) {
        // StringBuilder sb = new StringBuilder(p);
        // StringBuilder sb1 = new StringBuilder();
        // StringBuilder sb2 = new StringBuilder();
        // Stack<Character> st = new Stack<>();
        // int check=0;
        // while(sb.length() !=0){
        //     for(int i=0; i<sb.length(); i++){
        //         if(st.isEmpty()){
        //             st.push(sb.charAt(i));
        //         }else{
        //             if(sb.charAt(i)==')' && st.peek() ==')'){
        //                 sb.insert(0,st.pop());
        //                 break;
        //             }
        //             else{
        //                 if(sb.charAt(i) ==')'){
        //                     if(st.peek() =='('){
        //                         st.push('1');
        //                     }else{
        //                         if(st.peek()-'0'==1){
        //                             while(st.peek()-'0' == 1){
        //                                 sb2.append(st.pop());
        //                             }
        //                             if(st.peek() == '('){
        //                                 int index = sb1.length();
        //                                 for(int y=0; y<sb2.length(); y++){
        //                                     sb1.append('(').append(')');
        //                                 }
        //                                 sb1.insert(index,'(').insert(sb1.length(),')');
        //                             }
        //                             sb2.setLength(0);
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     }
        //     break;
        // }
        String answer = "";
        if(p.length()==0)
            return "";
        bracket("","",p);
        answer = sb.toString();
        System.out.println(answer);
        return answer;
    }
    private void bracket(String u , String v,String p){
        countBalance(p);
        checkU();
        v = vb.toString();
        u = ub.toString();
        if(v.length() == 0){
            if(goldbalance){
                sb.append(u);
            }else{
                sb.append("(").append(")");
            }
        }else{
            if(goldbalance){
                sb.append(u);
                bracket("","",v);
            }else{
                postsb.setLength(0);
                postsb.append(u);
                ub.setLength(0);
                sb.append("(");
                bracket("","",v);
                sb.append(")");
                if(postsb.length() > 1){
                    postsb.deleteCharAt(postsb.length()-1).deleteCharAt(0);
                    for(int i=0; i<postsb.length(); i++){
                        if(postsb.charAt(i) =='('){
                            postsb.setCharAt(i,')');
                        }else{
                            postsb.setCharAt(i,'(');
                        }
                    }
                }
                sb.append(postsb.toString());
            }
        }
    }
    private void countBalance(String p){
        ub.setLength(0);
        vb.setLength(0);
        int lcnt =0;
        int rcnt = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                lcnt++;
            }else{
                rcnt++;
            }
            ub.append(p.charAt(i));
            if(lcnt == rcnt){
                vb.append(p.substring(i+1));
                break;
            }
        }
    }
    private void checkU(){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<ub.length(); i++){
            if(st.isEmpty()){
                st.push(ub.charAt(i));
            }else{
                if(st.peek() == '(' && ub.charAt(i) == ')'){
                    st.pop();
                }else{
                    st.push(ub.charAt(i));
                }
            }
        }
        if(st.size()==0)
            goldbalance = true;
        else
            goldbalance = false;
    }
}
