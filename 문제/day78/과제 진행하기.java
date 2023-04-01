import java.util.*;
import java.time.*;
class Solution {
    class project{
        String project_id;
        LocalTime now;
        int time; 
        public project(String project_id, LocalTime now, int time){
            this.project_id = project_id;
            this.now = now;
            this.time = time;
        }
        private void setTime(LocalTime now){
            this.now = now;
        }
    }
    public String[] solution(String[][] plans) {
        Stack<project> st = new Stack<>();
        Arrays.sort(plans,(o1,o2)-> o1[1].compareTo(o2[1]));
        LocalTime post_time= LocalTime.now();
        Duration du;
        String[] answer = new String[plans.length];
        int index= 0;
        for(int i=0; i<plans.length; i++){
            if(st.isEmpty()){
                setDefaultProject(st,plans[i]);
            }else{
                boolean con = true;
                while(con){
                    if(st.isEmpty()){
                        break;
                    }
                    project pj = st.pop();
                    post_time = LocalTime.of(Integer.parseInt(plans[i][1].split(":")[0]),Integer.parseInt(plans[i][1].split(":")[1]));
                    du = Duration.between(pj.now,post_time);
                    if(du.toMinutes()>= pj.time){
                        answer[index++] = pj.project_id;
                        for(int y=0; y<st.size(); y++){
                            project tmp_pj = st.get(y);
                            tmp_pj.setTime(pj.now.plusMinutes(pj.time));
                            st.set(y,tmp_pj);
                        }
                        if(du.toMinutes() == pj.time){
                            break;
                        }
                    }else{
                        for(int y=0; y<st.size(); y++){
                            project tmp_pj = st.get(y);
                            tmp_pj.setTime(post_time);
                            st.set(y,tmp_pj);
                        }
                        setPauseProject(st,pj.project_id,post_time,pj.time-(int)du.toMinutes());
                        con = false;
                    }
                }
                setDefaultProject(st,plans[i]);
            }
        }
        while(!st.isEmpty()){
            answer[index++] = st.pop().project_id;
        }               
        
        return answer;
    }
    private void setDefaultProject(Stack<project> st , String[] plans){
        st.push(new project(plans[0],LocalTime.of(Integer.parseInt(plans[1].split(":")[0]),Integer.parseInt(plans[1].split(":")[1])),Integer.parseInt(plans[2])));
    }
    private void setPauseProject(Stack<project> st,String name, LocalTime time, int left_time){
        st.push(new project(name,time,left_time));
    }
}
