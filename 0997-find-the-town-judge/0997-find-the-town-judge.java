class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int[] trustScore = new int[n + 1];
        
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            
            trustScore[a]--; // a trusts someone
            trustScore[b]++; // b is trusted
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}