import java.util.*;
class Solution {
    ArrayList<int[]> list = new ArrayList<>();
    public ArrayList<int[]> solution(int n) {
        // n개 쌓인 탑에서 1번 시작점을 통해 도착점 3번으로 가는 방법, 2번이라는 경유지를 거침
        hanoi(n,1,3,2);
        
        return list;
    }
    private void hanoi(int cnt, int start, int end, int mid){
        if(cnt == 0) return;
        hanoi(cnt-1, start, mid, end);
        // 중간 경유점인 mid를 가기 위해 end를 거쳐가는 방법
        list.add(new int[]{start, end});
        // 중간 경유점으로 넘어왔으니 중간 경유점에서 end로 가는 방법
        hanoi(cnt-1, mid, end, start);
    }
}