class Solution {
    public int solution(String t, String p) {
        int p_length = p.length();
        String s;
        int answer = 0;
        for(int i=0; i< t.length()-(p_length-1); i++){
            s = t.substring(i,i+p_length);
            if(Long.parseLong(s) <= Long.parseLong(p)){
                answer++;
            }
        } 
        return answer;
    }
}
