class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int oneElement = target - nums[i];

            if(map.containsKey(oneElement)){
                return new int[]{map.get(oneElement), i};
            }
           
            map.put(nums[i], i);

            

        }
        return new int[]{};

        
    }
}