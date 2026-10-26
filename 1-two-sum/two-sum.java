class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int arr[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) == true){
                arr[0] = map.get(complement);
                arr[1] = i;
            }
            else{
                map.put(nums[i] , i);
            }
        }
            
            return arr;

            
        }
}


        
