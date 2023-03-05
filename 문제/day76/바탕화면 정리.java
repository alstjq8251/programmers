class Solution {
    public int[] solution(String[] wallpaper) {
        String [][] screen = new String[wallpaper.length][wallpaper[0].length()];
        for(int i=0; i<wallpaper.length; i++){
            for(int y=0; y<wallpaper[i].length(); y++){
                screen[i][y] = wallpaper[i].split("")[y];
            }
        }
        int[] answer = {-1,500,0,-1};
        for(int i=0; i<screen.length; i++){
            for(int y=0; y<screen[i].length; y++){
                if(screen[i][y].equals("#") && answer[0] == -1){
                    answer[0] = i;
                    answer[1] = Math.min(answer[1],y);
                    answer[2] = Math.max(answer[2],i+1);
                    answer[3] = Math.max(answer[3],y+1);
                }else if(screen[i][y].equals("#")){
                    answer[1] = Math.min(answer[1],y);
                    answer[2] = Math.max(answer[2],i+1);
                    answer[3] = Math.max(answer[3],y+1);
                }
            }
        }
        return answer;
    }
}
