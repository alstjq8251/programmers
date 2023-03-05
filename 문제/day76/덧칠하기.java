class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int preIndex = 1;
        int Index = 0;
        while(Index < section.length){
            if(preIndex < section[Index]){
                preIndex++;
            }else if(preIndex == section[Index]){
                answer++;
                preIndex += m;
                Index++;
            }else{
                Index++;
            }
        }
        return answer;
    }
}
