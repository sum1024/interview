import java.util.*;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> total = new  ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int last = nums.length-1;
        for(int i = 0;i<(nums.length-2) && nums[i]<=0;i++)
        {
            last = nums.length-1;
            for(int j = i+1;j<nums.length && 0 >= (nums[i]+nums[j]);j++)
            {
                for(int k = last;k>j && nums[k] >= 0;k--)
                {
                    if(0 == nums[i] + nums[j] + nums[k])
                    {
                        List<Integer> one = new ArrayList<Integer>();
                        one.add(nums[i]);
                        one.add(nums[j]);
                        one.add(nums[k]);
                        total.add(one);
                        last = k;
                        break;
                    }
                    else if(0 > nums[i] + nums[j] + nums[k])
                    {
                        if(k < last)
                            last = k+1;
                        break;
                    }
                    if(nums[k] == nums[k-1])
                    {
                        continue;
                    }
                }
                while(nums.length > j+1 &&nums[j] == nums[j+1])
                {
                    j++;
                }
            }
            while(nums.length > i+1 && nums[i] == nums[i+1])
            {
                i++;
            }
        }
        return total;
    }

    public static void main(String [] args)
    {
        Leetcode15 tmp = new Leetcode15();
        int[] list = {0,0,0};
        tmp.threeSum(list);
    }

}
