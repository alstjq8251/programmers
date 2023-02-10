import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,(o1,o2) -> {
            int sort = o1[col-1] - o2[col-1];
            if(sort == 0){
                return o2[0] - o1[0];
            }else
                return sort;
        });
        List<Integer> arr = new ArrayList<>();
        for(int i=row_begin; i<=row_end; i++){
            int sum=0;
            for(int y = 0; y<data[row_begin-1].length; y++){
                sum += data[i-1][y]%i;
            }
            arr.add(sum);
        }
        int bite = arr.get(0);
        for(int i=1; i<arr.size(); i++){
            bite ^= arr.get(i);
        }
        answer = bite;
        return answer;
    }
}
