import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
         {

            if(map.getOrDefault(target-nums[i],-1) !=-1)
            {
                return new int[] {i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
            
        }  
        return new int[] {-1,-1};
    }
    
}