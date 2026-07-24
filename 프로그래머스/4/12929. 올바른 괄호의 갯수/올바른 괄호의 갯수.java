class Solution {
        int answer;
        public int solution(int n) {
            recursive(0, 0, n);
            return this.answer;
        }
        void recursive(int leftCount, int rightCount, int n) {
            if (leftCount == n && rightCount == n) { answer++; return; }
            if (leftCount < n) recursive(leftCount + 1, rightCount, n);       // '(' 추가
            if (rightCount < leftCount) recursive(leftCount, rightCount + 1, n); // ')' 추가 (leftCount보다 적을 때만)
        }
}