import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> st = new Stack();
        int answer = 0;
        for(int i=0; i<moves.length; i++){
            int index = moves[i]-1;
            int start=0;
            while(start < board.length){
                if(board[start][index] != 0){
                    if(st.isEmpty()){
                        st.push(board[start][index]);
                        board[start][index]=0;
                        break;
                    }else{
                        if(st.peek() == board[start][index]){
                            board[start][index]=0;
                            st.pop();
                            answer+=2;
                            break;
                        }else{
                            st.push(board[start][index]);
                            board[start][index]=0;
                            break;
                        }
                    }
                }
                start++;
            }
        }
        
        return answer;
    }
}
