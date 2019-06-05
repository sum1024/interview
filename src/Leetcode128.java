import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 0)
        {
            return 0;
        }
        Set<Integer> numsset = new HashSet<>();
        for(int num:nums)
        {
            numsset.add(num);
        }
        int maxlength = 1;
        int curlength;
        int curnum;
        for(int num:numsset)
        {
            curlength = 1;
            if(!numsset.contains(num-1))
            {
                curnum = num;
                while(numsset.contains(curnum+1))
                {
                    curnum++;
                    curlength++;
                }
                maxlength = Math.max(maxlength,curlength);
            }
        }
        return maxlength;
    }
}
