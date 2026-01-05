import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        List<String> columns = List.of("code", "date", "maximum", "remain");
        
        int extIndex = columns.indexOf(ext);
        int sortIndex = columns.indexOf(sort_by);
        
        
        return Arrays.stream(data)
            .filter(f -> f[extIndex] < val_ext)
            .sorted(Comparator.comparingInt(d -> d[sortIndex]))
            .toArray(int[][]::new);
    }
}
