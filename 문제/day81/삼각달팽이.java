import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1) / 2];
        int lift_snail = 1;
        int [][]snail_arr = new int[n][n]; 
        int x = -1;
        int y = 0;
        
        for(int i=1; i<=n; i++){
            for(int arr_y=i; arr_y<=n; arr_y++){
                if(i %3 == 1){
                    x++;
                }else if(i % 3 == 2){
                    y++;
                }else {
                    x--;
                    y--;
                }
                snail_arr[x][y] = lift_snail++;
            }
        }
        
        int arr_index=0;
        for(int i=0; i<snail_arr.length; i++){
            for(int arr_y=0; arr_y<snail_arr[i].length; arr_y++){
                if(snail_arr[i][arr_y]!= 0){
                    answer[arr_index++] = snail_arr[i][arr_y];
                }
            }
        }
        return answer;
    }
}
