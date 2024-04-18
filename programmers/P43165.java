class P43165 {
    static int answer = 0;
        
    public int solution(int[] numbers, int target) {
        solve(numbers, 0, 0, target);
        
        return answer;
    }
    
    public void solve(int[] numbers, int depth, int sum, int target){
        if(depth==numbers.length){
            if(sum==target)
                answer++;
            return;
        }
        solve(numbers, depth+1, sum+numbers[depth], target);     
        solve(numbers, depth+1, sum-numbers[depth], target);
    }
}