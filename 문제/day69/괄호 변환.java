import java.util.*;
class Solution {
    boolean goldbalance = false;
    public String solution(String p) {
        String answer = "";
        answer = bracket(p);
        return answer;
    }
    private String bracket(String p){
        if(p.length() == 0)
            return "";
        StringBuilder ub = new StringBuilder();
        StringBuilder vb = new StringBuilder();
        int lcnt = 0;
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
        checkU(ub);
        if(goldbalance){
            return ub.toString() + bracket(vb.toString());
        }else{
            StringBuilder tms = new StringBuilder();
            tms.append("(");
            tms.append(bracket(vb.toString()));
            tms.append(")");
            if(ub.length() > 1){
                ub.deleteCharAt(ub.length()-1).deleteCharAt(0);
                for(int i=0; i<ub.length(); i++){
                    if(ub.charAt(i) == '('){
                        tms.append(')');
                    }else{
                        tms.append('(');
                    }
                }
            }
            return tms.toString();
        }
    }
    private void checkU(StringBuilder ub){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<ub.length(); i++){
            if(st.isEmpty()){
                st.push(ub.charAt(i));
            }else{
                if(st.peek() == '(' && ub.charAt(i) == ')'){
                    st.pop();
                }else{
                    if(st.peek() == ')')
                        break;
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
