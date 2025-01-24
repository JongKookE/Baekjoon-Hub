import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int person, relation, count;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static boolean valid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		person = Integer.parseInt(st.nextToken());
		relation = Integer.parseInt(st.nextToken());
		graph = new ArrayList[person];
		visited = new boolean[person];
		for(int i = 0; i < person; i++) graph[i] = new ArrayList<>(); 
		
		for(int i = 0; i < relation; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
		for(int i = 0; i < person; i++) {
			visited[i] = true;
			dfs(i, 0); // i 번째 친구로부터 출발해 본다.
			if(valid) {
				System.out.println(1);
				// 메인 메소드 이기 때문에 바로 시스템이 종료됌
				return;
			}
			visited[i] = false; // 관계를 만족하지 못했으므로 visit를 원복
		}
		// 모두 실패했다면
		System.out.println(0);
	}
	static void dfs(int start, int depth) {
		if(valid) return;
		
		if(depth == 4) {
			valid = true;
			return;
		}
		visited[start] = true;
		for(int forElem : graph[start]) {
			if(visited[forElem]) continue;
			visited[forElem] = true;
			dfs(forElem, depth+1);
			visited[forElem] = false;
		}		
	}
}
