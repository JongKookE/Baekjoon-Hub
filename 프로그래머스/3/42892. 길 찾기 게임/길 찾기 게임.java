import java.util.*;

class Solution {
    int[][] answer;
    int cnt;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        Arrays.sort(nodes);

        Node root = nodes[0];
        for(int i = 1; i < nodes.length; i++) insert(root, nodes[i]);

        preorder(root);
        cnt = 0;
        postorder(root);
        return answer;
    }

    void preorder(Node root){
        if(root == null) return;
        answer[0][cnt++] = root.index;
        preorder(root.left);
        preorder(root.right);
    }

    void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        answer[1][cnt++] = root.index;
    }

    void insert(Node parent, Node child) {
        if(parent.x > child.x){
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }
        else{
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }

    class Node implements Comparable<Node>{
        int index, x, y;
        Node right, left;
        public Node(int index, int x, int y){
            this.index = index;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o){
            if(o.y == this.y) return this.x - o.x;
            return o.y - this.y;
        }

        @Override
        public String toString() {
            return String.format("[index: %d, x: %d, y: %d]", this.index, this.x, this.y);
        }
    }
}