import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int buildingCount, max;
    static int[] buildings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        buildingCount = Integer.parseInt(br.readLine());
        buildings = new int[buildingCount];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int b = 0; b < buildingCount; b++) buildings[b] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < buildingCount; i++) max = Math.max(getCount(i), max);

        System.out.println(max);

    }

    private static int getCount(int i) {
        double currentSlope = 0;
        int count = 0;
        // 왼쪽은 이전의 기울기보다 작아야 관측 가능
        for(int j = i - 1; j >= 0; j--){
            double slope = calcSlope(buildings[i], buildings[j], i, j);
            // 자신의 바로 옆에 있는 빌딩은 무조건 관측가능, 바로 기울기 갱신
            if(j == i - 1 || currentSlope > slope){
                currentSlope = slope;
                count++;
            }
        }

        // 오른쪽은 이전의 기울기보다 커야 관측 가능
        for(int j = i + 1; j < buildingCount; j++){
            double slope = calcSlope(buildings[i], buildings[j], i, j);
            // 자신의 바로 옆에 있는 빌딩은 무조건 관측가능, 바로 기울기 갱신
            if(j == i + 1 || currentSlope < slope){
                currentSlope = slope;
                count++;
            }
        }
        return count;
    }

    static double calcSlope(int height1, int height2, int width1, int width2){
        return  ((double)height1-(double)height2)/((double)width1-(double)width2);
    }
}