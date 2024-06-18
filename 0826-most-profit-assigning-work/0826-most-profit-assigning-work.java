class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int n = difficulty.length;
        int m = worker.length;

        // Combine and sort jobs based on difficulty
        int[][] jobs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Sort workers
        Arrays.sort(worker);

        // Track the maximum profit available for any given difficulty
        int maxProfit = 0;
        int jobIndex = 0;
        int totalProfit = 0;

        // Assign jobs to workers
        for (int ability : worker) {
            
            while (jobIndex < n && ability >= jobs[jobIndex][0]) {
                
                maxProfit = Math.max(maxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
        
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}