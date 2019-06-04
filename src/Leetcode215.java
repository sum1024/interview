public class Leetcode215 {

    /*
    * 执行用时 : 1 ms, 在Kth Largest Element in an Array的Java提交中击败了100.00% 的用户
内存消耗 : 36.7 MB, 在Kth Largest Element in an Array的Java提交中击败了95.19% 的用户
    * */
    public int findKthLargest(int[] nums, int k) {
        if(k>=nums.length/2)
        {
            quickSort(nums,0,nums.length-1,nums[0],nums.length-k+1,0);
            return nums[nums.length-k];
        }
        else
        {
            quickSort(nums,0,nums.length-1,nums[0],k,1);
            return nums[k-1];
        }
    }

    public void quickSort(int[] topk, int start,int end,int std,int k,int flag)
    {
        int tmp = 0;
        int startrc = start;
        int endrc = end;
        if(flag == 1)
        {
            while(start < end)
            {
                while(start < end && topk[start] >= std){
                    start++;
                }
                while(start < end && topk[end] < std){
                    end--;
                }
                if(start < end)
                {
                    tmp = topk[start];
                    topk[start] = topk[end];
                    topk[end] = tmp;
                }
            }
            if(topk[start] < std)
            {
                start--;
            }
        }
        else
        {
            while(start < end)
            {
                while(start < end && topk[start] <= std){
                    start++;
                }
                while(start < end && topk[end] > std){
                    end--;
                }
                if(start < end)
                {
                    tmp = topk[start];
                    topk[start] = topk[end];
                    topk[end] = tmp;
                }
            }
            if(topk[start] > std)
            {
                start--;
            }
        }
        tmp = topk[start];
        topk[start] = topk[startrc];
        topk[startrc] = tmp;
        if(start+1 == k)
        {
            return;
        }
        else if(start+1 > k)
        {
            quickSort(topk,startrc,start-1,topk[startrc],k,flag);
        }
        else
        {
            quickSort(topk,start+1,endrc,topk[start+1],k,flag);
        }
    }

/*    public int findKthLargest(int[] nums, int k) {
        for(int i=1;i<nums.length;i++)
        {
            if(i < k)
            {
                if(nums[i] > nums[i-1])
                {
                    exchangeTopk(nums,i+1,nums[i]);
                }
            }
            else
            {
                if(nums[i] > nums[k-1])
                {
                    exchangeTopk(nums,k,nums[i]);
                }
            }
        }
        return nums[k-1];
    }

    public void exchangeTopk(int[] topk, int k,int num)
    {
        int start = 0, end = k-1, mid = (start+end)/2;
        do {
            if(num > topk[mid])
            {
                end = mid-1;
                mid = (start+end)/2;
            }
            else if(num < topk[mid])
            {
                start = mid+1;
                mid = (start+end)/2;
            }
            else
            {
                break;
            }
        }while(start < end);
        if(num < topk[mid])
        {
            mid++;
        }
        for(int i = k-1;i>mid;i--)
        {
            topk[i] = topk[i-1];
        }
        topk[mid] = num;
    }*/



/*    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length)
        {
            return -1;
        }
        int[] topk = new int[k];
        for(int ini = 0;ini < k;ini++)
        {
            topk[ini] = Integer.MIN_VALUE;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>topk[k-1])
            {
                exchangeTopk(topk,nums[i]);
            }
        }
        return topk[k-1];
    }

    public void exchangeTopk(int[] topk,int num)
    {
        int addr = 0;
        int start = 0, end = topk.length-1, mid = (start+end)/2;
        do {
            if(num > topk[mid])
            {
                end = mid-1;
                mid = (start+end)/2;
            }
            else if(num < topk[mid])
            {
                start = mid+1;
                mid = (start+end)/2;
            }
            else
            {
                break;
            }
        }while(start < end);
        if(num < topk[mid])
        {
            mid++;
        }
        for(int i = topk.length-1;i>mid;i--)
        {
            topk[i] = topk[i-1];
        }
        topk[mid] = num;
    }*/

    public static void main(String [] args)
    {
        int[] nums= {2,1};
        Leetcode215 tmp = new Leetcode215();
        tmp.findKthLargest(nums,2);
    }
}
