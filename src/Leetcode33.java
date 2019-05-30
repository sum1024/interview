public class Leetcode33 {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
        {
            return -1;
        }
        int start = 0, end = nums.length-1, mid = (start+end)/2;
        boolean flag = false;
        do
        {
            if(nums[mid] == target)
            {
                flag = true;
                break;
            }
            if(nums[mid] >= nums[start])
            {
                if(nums[start] <= target && nums[mid] > target)
                {
                    end = mid-1;
                    mid = (start+end)/2;
                }
                else
                {
                    start = mid+1;
                    mid = (start+end)/2;
                }
            }
            else if(nums[end] >= nums[mid])
            {
                if(nums[mid] < target && nums[end] >= target)
                {
                    start = mid+1;
                    mid = (start+end)/2;
                }
                else
                {
                    end = mid-1;
                    mid = (start+end)/2;
                }
            }
            else
            {
                break;
            }
        }while(end >= start);
        if(flag)
        {
            return mid;
        }
        return -1;
    }

    public static void main(String [] args)
    {
        Leetcode33 tmp = new Leetcode33();
        int[] nums = {4,5,6,7,0,1,2};
        tmp.search(nums,0);
    }
}
