class Solution {
    int index=0;
    int[][] answer;
    public int[][] solution(int n) {
        answer = new int[((int)Math.pow(2,n))-1][2];
        hanoi(n, 1,3,2);
        return answer;
    }
    public void hanoi(int n, int start, int end, int via){
        if(n == 1){
            answer[index][0] = start;
            answer[index][1] = end;
            index++;
        }else{
            hanoi(n-1,start,via,end);
            answer[index][0] = start;
            answer[index][1] = end;
            index++;
            hanoi(n-1,via,end,start);
        }
        
    }
}
