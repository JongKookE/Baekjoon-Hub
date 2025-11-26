
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int switchCount = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] switchStatus = new boolean[switchCount+1];
        for(int sc = 1; sc <= switchCount; sc++) {
            if(st.nextToken().equals("0")) continue;
            switchStatus[sc] = true;
        }

        int studentCount = Integer.parseInt(br.readLine());
        for(int stc = 0; stc < studentCount; stc++){
            st = new StringTokenizer(br.readLine());
            GenderAndNumber genderAndNumber = new GenderAndNumber(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            genderAndNumber.changeSwitchStatus(switchStatus);
        }
        for(int sc = 1; sc <= switchCount; sc++){
            if(switchStatus[sc]) sb.append(1);
            else sb.append(0);

            sb.append(" ");

            if(sc % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }
    static class GenderAndNumber{
        int gender, number;
        public GenderAndNumber(int gender, int number){
            this.gender = gender;
            this.number = number;
        }

        @Override
        public String toString() {
            return "GenderAndNumber{" +
                    "gender=" + gender +
                    ", number=" + number +
                    '}';
        }

        public void changeSwitchStatus(boolean[] switchStatus){
            // 남성
            if(this.gender == 1) {
                for(int n = number; n < switchStatus.length; n += number){
                    switchStatus[n] = !switchStatus[n];
                }
            }
            // 여성
            else {
                int start = this.number-1, end = this.number+1;
                switchStatus[this.number] = !switchStatus[this.number];
                while(start > 0 && end < switchStatus.length){
                    if(switchStatus[start] != switchStatus[end]) return;
                    switchStatus[start] = !switchStatus[start];
                    switchStatus[end] = !switchStatus[end];
                    start--;
                    end++;
                }
            }
        }
    }
}
