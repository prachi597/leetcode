class Solution {
    public int jump(int[] nums) {

        int jumps = 0;      // number of jumps taken
        int end = 0;        // end of current jump range
        int farthest = 0;   // farthest we can reach

        for (int i = 0; i < nums.length - 1; i++) {

            // update farthest reach
            farthest = Math.max(farthest, i + nums[i]);

            // if we reach the end of current range
            if (i == end) {
                jumps++;
                end = farthest; // start new range
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {2,3,0,1,4};

        System.out.println(s.jump(nums1)); // 2
        System.out.println(s.jump(nums2)); // 2
    }
}