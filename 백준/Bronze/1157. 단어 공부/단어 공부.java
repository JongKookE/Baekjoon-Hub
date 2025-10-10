import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chs = br.readLine().toCharArray();
        for(char ch : chs){
            char lowerCh = Character.toLowerCase(ch);
            map.put(lowerCh, map.getOrDefault(lowerCh, 0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        if(list.size() >= 2) System.out.println(Objects.equals(list.get(0).getValue(), list.get(1).getValue()) ? '?' : Character.toUpperCase(list.get(0).getKey()));
        else System.out.println(Character.toUpperCase(list.get(0).getKey()));
    }
}
