import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    static String S, T;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        S = br.readLine();
        T = br.readLine();

        System.out.println(dfs(0, T.length()-1, false) ? 1 : 0);
    }
    static boolean dfs(int left, int right, boolean reversed) {
        if (S.length() == right - left + 1)
            return isSame(left, right, reversed);

        /*
        문자열의 뒤에 A를 추가한다. -> 문자열의 뒤에 A를 제거한다 / when? 문자열 제일 뒤가 A일때
        문자열의 뒤에 B를 추가하고 문자열을 뒤집는다. -> 문자열의 뒤에 B를 제거하고 문자열을 뒤집는다 / when? 문자열의 제일 앞이 B일때
        ? 문자열의 제일 앞이 B면서 제일 뒤가 A일 경우
        ? 문자열의 제일 앞이 B가 아니면서 제일 뒤가 A가 아닐때

         BAABAAAAAB -> left 0, right 9
         문자열의 첫번째가 B니까 B를 지우고 -> left 1, right 9
         BAAAAABAA left 9, right 1 -> left와 right를 바꾸고

         */
        // 정방향
        if (!reversed) {
            if (T.charAt(right) == 'A' && dfs(left, right - 1, false)) return true;
            if (T.charAt(left) == 'B' && dfs(left + 1, right, true)) return true;
        }
        // 뒤집은 방향
        else {
            // 뒤집은 상태에서 인덱스를 조절해야하니 left와 right의 인덱스 변화를 반대로 생각해야함
            if (T.charAt(left) == 'A' && dfs(left + 1, right, true)) return true;
            if (T.charAt(right) == 'B' && dfs(left, right - 1, false)) return true;
        }

        return false;
    }

    static boolean isSame(int left, int right, boolean reversed){
        if(!reversed){
            for(int i = 0; i < S.length(); i++){
                if(S.charAt(i) != T.charAt(left+i)) return false;
            }
        }
        else {
            for(int i = 0; i < S.length(); i++){
                if(S.charAt(i) != T.charAt(right-i)) return false;
            }
        }
        return true;
    }
}