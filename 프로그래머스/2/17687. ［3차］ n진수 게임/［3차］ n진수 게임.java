import java.util.List;
class Solution {
    List<String> numbers = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F");
    StringBuilder sb = new StringBuilder();
    public String solution(int n, int t, int m, int p) {
        int cntSayNumber = 0;
        int target = 0;
        int cnt = 0;
        while(true){
            String convert = target == 0 ? "0" : toSystem(n, target, "");
            for(int i = 0; i < convert.length(); i++){
                cnt++;
                if(cnt == p) {
                    sb.append(convert.charAt(i));
                    cntSayNumber++;
                    if(cntSayNumber == t) return sb.toString();
                }
                if(cnt == m) cnt = 0;
            }
            target++;
        }

    }
    String toSystem(int n, int target, String result){
        if(target == 0) return result;

        int next = target/n;
        int makeSystemNumber = target%n ;
        return toSystem(n, next, numbers.get(makeSystemNumber) + result);
    }
}