import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 执行用时 :
9 ms
, 在所有Java提交中击败了
93.83%
的用户
内存消耗 :
44.9 MB
, 在所有Java提交中击败了
51.65%
的用户
* */

public class Leetcode56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        sortListbyFirst(intervals,0,intervals.length-1);
        int[] flag = new int[intervals.length];
        int total = 0;
        for(int i=1;i<flag.length;i++)
        {
            if(intervals[i][0] <= intervals[i-1][1])
            {
                if(intervals[i][1] <= intervals[i-1][1])
                {
                    intervals[i][0] = intervals[i-1][0];
                    intervals[i][1] = intervals[i-1][1];
                }
                else
                {
                    intervals[i][0] = intervals[i-1][0];
                }
                flag[i-1] = 0;
            }
            else
            {
                total++;
                flag[i-1] = 1;
            }
        }
        total++;
        flag[flag.length-1] = 1;
        int[][] result = new int[total][2];
        int addr = 0;
        for(int i = 0;i<flag.length;i++)
        {
           if(flag[i] == 1)
           {
               result[addr][0] = intervals[i][0];
               result[addr++][1] = intervals[i][1];
           }
        }
        return result;
    }

    public void sortListbyFirst(int[][] list,int start,int end)
    {
        int head = start,tail =end;
        int[] tmp = new int[2];
        while(head < tail)
        {
            while(head < tail)
            {
                if(list[head][0] > list[start][0])
                {
                    break;
                }
                else
                {
                    head++;
                }
            }
            while(head < tail)
            {
                if(list[tail][0] <= list[start][0])
                {
                    break;
                }
                else
                {
                    tail--;
                }
            }
            if(head < tail)
            {
                tmp[0] = list[head][0];
                tmp[1] = list[head][1];
                list[head][0] = list[tail][0];
                list[head][1] = list[tail][1];
                list[tail][0] = tmp[0];
                list[tail][1] = tmp[1];
            }
            else
            {
                if(list[head][0] >= list[start][0])
                {
                    head--;
                }
                tmp[0] = list[head][0];
                tmp[1] = list[head][1];
                list[head][0] = list[start][0];
                list[head][1] = list[start][1];
                list[start][0] = tmp[0];
                list[start][1] = tmp[1];
                break;
            }
        }
        if(start < head-1)
        {
            sortListbyFirst(list,start,head-1);
        }
        if(head+1 < end)
        {
            sortListbyFirst(list,head+1,end);
        }
    }

    public static void main(String[] args)
    {
        Leetcode56 test = new Leetcode56();
        //[1,3],[2,6],[8,10],[15,18]
        int[][] arr = new int[5][2];
        arr[0][0] = 2;
        arr[0][1] = 3;
        arr[1][0] = 5;
        arr[1][1] = 5;
        arr[2][0] = 2;
        arr[2][1] = 2;
        arr[3][0] = 3;
        arr[3][1] = 4;
        arr[4][0] = 3;
        arr[4][1] = 4;
        test.merge(arr);
    }
}
