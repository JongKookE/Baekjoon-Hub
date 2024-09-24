import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String startWord = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String lastWord = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String returnWord = "라고 답변하였지.";
    static List<String> professorsSays = List.of(
            "\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
    );
    static String cutLine = "____";
    static final int says = 4;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb.append(startWord).append("\n");
        whatIsRecursiveFunction(0);
        System.out.println(sb.toString());
    }
    static void whatIsRecursiveFunction(int depth){
        if(depth == N) {
            sb.append(String.valueOf(cutLine).repeat(Math.max(0, depth)));
            sb.append(professorsSays.get(0)).append("\n");
            sb.append(String.valueOf(cutLine).repeat(Math.max(0, depth)));
            sb.append(lastWord).append("\n");
            sb.append(String.valueOf(cutLine).repeat(Math.max(0, depth)));
            sb.append(returnWord).append("\n");
            return;
        }
        for(int s = 0; s < says; s++){
            sb.append(String.valueOf(cutLine).repeat(Math.max(0, depth)));
            sb.append(professorsSays.get(s)).append("\n");
            if(s == says - 1) {
                whatIsRecursiveFunction(depth + 1);
                sb.append(String.valueOf(cutLine).repeat(Math.max(0, depth)));
                sb.append(returnWord).append("\n");
            }
        }
    }
}