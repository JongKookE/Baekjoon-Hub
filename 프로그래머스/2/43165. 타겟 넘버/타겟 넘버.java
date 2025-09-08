class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
    int dfs(int depth, int sum, int[] numbers, int target){
        if(depth == numbers.length){
            return target == sum ? 1 : 0;
        }
        int count = 0;
        count += dfs(depth+1, sum + numbers[depth], numbers, target);
        count += dfs(depth+1, sum - numbers[depth], numbers, target);
        return count;
    }
}