class Solution {
    public int peakValleyDifference(int[] nums) {

        int peaksum = 0;
        int valleysum = 0;

        for(int i=1;i<nums.length-1;i++)
        {
             int currentElement = nums[i];
             int prevElement = nums[i-1];
             int nextElement =nums[i+1];

             if(currentElement > prevElement && currentElement > nextElement)
             {
                 peaksum +=currentElement;
             }
             if(currentElement < prevElement && currentElement < nextElement)
             {
                 valleysum +=currentElement;
             }
        }
       
        return peaksum - valleysum;
    }
}