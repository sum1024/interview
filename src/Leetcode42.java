public class Leetcode42 {


    /*
    * 执行用时 :
5 ms
, 在所有 Java 提交中击败了
44.09%
的用户
内存消耗 :
36.1 MB
, 在所有 Java 提交中击败了
93.96%
的用户
    *
    * */
    //使用栈
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int total = 0,top = 0,last = 0;
        int[][] stack = new int[height.length][2];
        while(stack[0][1] < height.length && height[stack[0][1]] == 0)
        {
            stack[0][1]++;
        }
        if(stack[0][1] < height.length)
        {
            stack[0][0] = height[stack[0][1]];
            top++;
        }
        for(int i = stack[0][1]+1;i<height.length;i++)
        {
            if(height[i] == 0)
            {
                continue;
            }
            if(height[i] == stack[top-1][0])
            {
                total += height[i] * (i - stack[top-1][1]-1);
                stack[top-1][1] = i;
            }
            else if(height[i] < stack[top-1][0])
            {
                total += height[i] * (i - stack[top-1][1]-1);
                stack[top][0] = height[i];
                stack[top][1] = i;
                top++;
            }
            else
            {
                last = 0;
                while((top-1)>=0)
                {
                    if(stack[top-1][0] < height[i])
                    {
                        total += (stack[top-1][0] - last)*(i - stack[top-1][1] - 1);
                        last = stack[top-1][0];
                        stack[top-1][0] = 0;
                        stack[top-1][1] = 0;
                        top--;
                    }
                    else if(stack[top-1][0] == height[i])
                    {
                        total += (stack[top-1][0] - last)*(i - stack[top-1][1] - 1);
                        last = stack[top-1][0];
                        stack[top-1][0] = 0;
                        stack[top-1][1] = 0;
                        top--;
                        break;
                    }
                    else
                    {
                        total += (height[i] - last)*(i - stack[top-1][1] - 1);
                        break;
                    }
                }
                stack[top][0] = height[i];
                stack[top][1] = i;
                top++;
            }
        }
        return total;
    }

/*    *//*
    *执行用时 :
4 ms
, 在所有 Java 提交中击败了
57.75%
的用户
内存消耗 :
36 MB
, 在所有 Java 提交中击败了
95.71%
的用户
    *
    * *//*
    public int trap(int[] height) {
        int total = 0,last = 0,cur=0,second=0;
        while(last<height.length && height[last] == 0)
        {
            last++;
        }
        for(int i = last+1;i<height.length;i++)
        {
            if(height[i] == 0)
            {
                continue;
            }
            for(int j=i-1;j>=last;j--)
            {
                if(height[j] == 0 || cur >= height[j])
                {
                    continue;
                }
                else
                {
                    cur = height[j];
                    if(cur >= height[i])
                    {
                        total += (height[i]-second) * (i-j-1);
                        break;
                    }
                    else
                    {
                        total +=(cur-second) * (i-j-1);
                        second = cur;
                    }
                }
            }
            cur = 0;
            second = 0;
        }
        return total;
    }*/

    public static void main(String[] args) {
        Leetcode42 test = new Leetcode42();
        int[] arr = {4,2,3};
        test.trap(arr);
    }
}
