class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxL = new int[n];
        int[] minS = new int[n];

        maxL[0] = nums[0];
        for(int i = 1; i < n; i++){
            maxL[i] = Math.max(maxL[i-1], nums[i]);
        }

        minS[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            minS[i] = Math.min(minS[i+1], nums[i]);
        }

        for(int i = 0; i < n; i++){
            if(maxL[i] - minS[i] <= k) return i;
        }
        return -1;
    }
}