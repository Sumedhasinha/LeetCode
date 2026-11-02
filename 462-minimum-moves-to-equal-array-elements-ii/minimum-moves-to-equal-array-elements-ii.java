class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n/2];
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] > mid){
                ans += nums[i] - mid;
            }
            else if(nums[i] < mid){
                ans += mid - nums[i];
            }
        }

        return ans;
    }
}