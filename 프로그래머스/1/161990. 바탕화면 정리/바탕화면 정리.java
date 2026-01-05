class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, top = Integer.MAX_VALUE, bottom = Integer.MIN_VALUE;
        int sLength = wallpaper[0].length();
        for(int y = 0; y < wallpaper.length; y++){
            for(int x = 0; x < sLength; x++){
                if(wallpaper[y].charAt(x) == '.') continue;
                left = Math.min(x, left);            
                right = Math.max(x, right);
                top = Math.min(y, top);
                bottom = Math.max(y, bottom);
                
            }
        }
        // System.out.printf("%d, %d, %d, %d\n", top, left, bottom+1, right+1);
        return new int[]{top, left, bottom+1, right+1};
    }
}

/**
. # . . .
. . # . .
. . . # .

-> (0,1), (1, 2), (2, 3)

-> (1, 5), (2, 6), (2, 7), (3, 3), (3, 4), (4, 5)
top = 1, left = 3, right = 7, bottom = 4
제일 left에 있는 x 좌표와 top의 y 좌표를 합침,
제일 right에 있는 x 좌표와 top의 y 좌표를 합침,

제일 left에 있는 x 좌표와 bottom의 y 좌표를 합침,
제일 right에 있는 x 좌표와 bottom의 y 좌표를 합침,
**/