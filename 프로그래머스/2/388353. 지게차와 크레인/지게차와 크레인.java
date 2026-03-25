import java.util.*;

class Solution {
    int row, col, discount;
    boolean[][] visited;
    boolean[][] outer;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    HashMap<Character, ArrayList<Node>> alphabetMaps = new HashMap<>();

    public int solution(String[] storage, String[] requests) {
        row = storage.length;
        col = storage[0].length();
        visited = new boolean[row + 1][col + 1];
        outer = new boolean[row + 1][col + 1];

        for (int r = 1; r <= row; r++) {
            char[] chs = storage[r - 1].toCharArray();
            for (int c = 1; c <= col; c++) {
                char ch = chs[c - 1];
                alphabetMaps.computeIfAbsent(ch, key -> new ArrayList<>()).add(new Node(r, c));
            }
        }

        for (String str : requests) {
            rebuildOuter();
            char ch = str.charAt(0);
            if (str.length() == 1) hooks(ch, true);
            else hooks(ch, false);
        }

        return row * col - discount;
    }

    void hooks(char ch, boolean isEdge) {
        ArrayList<Node> list = alphabetMaps.get(ch);
        if (list == null) return;

        for (Node node : list) {
            int r = node.r, c = node.c;
            if (visited[r][c]) continue;

            if (isEdge && !outer[r][c]) continue;
            visited[r][c] = true;
            discount++;
        }
    }

    void rebuildOuter() {
        outer = new boolean[row + 1][col + 1];
        boolean[][] emptyVisited = new boolean[row + 2][col + 2];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0));
        emptyVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = current.r + dr[dir];
                int nc = current.c + dc[dir];

                if (!isPaddedRange(nr, nc) || emptyVisited[nr][nc]) continue;

                if (isInnerRange(nr, nc) && !visited[nr][nc]) {
                    outer[nr][nc] = true;
                    continue;
                }

                emptyVisited[nr][nc] = true;
                queue.offer(new Node(nr, nc));
            }
        }
    }

    boolean isInnerRange(int r, int c) {
        return (r > 0 && c > 0 && r <= row && c <= col);
    }

    boolean isPaddedRange(int r, int c) {
        return (r >= 0 && c >= 0 && r <= row + 1 && c <= col + 1);
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}