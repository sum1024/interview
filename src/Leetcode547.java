import java.util.*;

public class Leetcode547 {
    public int findCircleNum(int[][] M) {
        int total = 0;
        int[] flag = new int[M.length];
        List<Integer> que = new ArrayList<Integer>();
        int cur = -1;
        for(int i=0;i<M.length;i++)
        {
            if(flag[i] == 0)
            {
                total++;
                que.add(i);
                while(que.size() > 0)
                {
                    cur = que.remove(0);
                    for(int j=0;j<M.length;j++)
                    {
                        if(M[cur][j]==0)
                        {
                            continue;
                        }
                        else
                        {
                            if(flag[j] == 1)
                            {
                                continue;
                            }
                            else
                            {
                                flag[j] = 1;
                                que.add(j);
                            }
                        }
                    }
                }
            }
            else
            {
                continue;
            }
        }
        return total;
    }
}
