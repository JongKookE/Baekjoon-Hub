import java.util.*;


class Solution {
        int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1}; // N, S, W, E;
        int N = 0, S = 1, W = 2, E = 3;
        HashMap<Character, Integer> map = new HashMap<>();
        int y, x;
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];
            int height = park.length;
            int width = park[0].length();
            map.put('N', N); map.put('S', S); map.put('W', W); map.put('E', E);
            int[] yx = findStartDot(park);
            y = yx[0]; x = yx[1];

            for(String route : routes) jogging(park, route, height, width);

            return new int[]{y, x};
        }

        void jogging(String[] park, String route, int height, int width) {
            int dir =  map.get(route.charAt(0));
            int reps = route.charAt(2) - '0';
            int tempY = y, tempX = x;
            for(int i = 0; i < reps; i++) {
                tempY += dy[dir];
                tempX += dx[dir];
                if(!isInOrAccepted(park, tempY, tempX, height, width)) return;
            }
            y = tempY;
            x = tempX;
        }

        boolean isInOrAccepted(String[] park, int y, int x, int height, int width){
            return y >= 0 && x >= 0 && y < height && x < width && park[y].charAt(x) != 'X';
        }

        int[] findStartDot(String[] park){
            int height = park.length;
            int width = park[0].length();

            for(int i = 0; i < height; i++){
                for(int j = 0; j < width; j++){
                    if(park[i].charAt(j) == 'S') return new int[]{i, j};
                }
            }
            return new int[]{-1, -1};
        }
}