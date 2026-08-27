class Solution {
    public boolean containsDuplicate(int[] nums) {
        // 1-Approach
        // Arrays.sort(nums);
        // for(int i = 0; i < nums.length-1; i++){
        //     if(nums[i]==nums[i+1]){
        //         return true;
        //     }
        // }
        // return false;

        // 2-Approach
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}