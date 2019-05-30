public class Leetcode674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 0)
        {
            return 0;
        }
        int max = 0,count = 1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1] > nums[i])
            {
                count++;
            }
            else
            {
                if(max < count)
                {
                    max = count;
                }
                count =1;
            }
        }
        if(max < count)
        {
            max = count;
        }
        return max;
    }
}
