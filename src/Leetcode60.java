import java.util.ArrayList;
import java.util.List;

/*
*
* 执行用时 : 5 ms, 在Permutation Sequence的Java提交中击败了51.84% 的用户
* 内存消耗 : 34 MB, 在Permutation Sequence的Java提交中击败了91.41% 的用户
*/

public class Leetcode60 {
    public String getPermutation(int n, int k) {
        int[] combi = new int[n];
        List<Integer> used = new ArrayList<Integer>();
        combi[0]=1;
        used.add(1);
        for(int i=2;i<=n;i++)
        {
            combi[i-1] = combi[i-2] * i;
            used.add(i);
        }
        if(k>combi[n-1])
        {
            return  null;
        }
        String result = "";
        int index;
        int left = k;
        for(int i = n-2;i>=0;i--)
        {
            index = left/combi[i];
            left = left%combi[i];
            if(left == 0)
            {
                if(index == 0)
                {
                    result = result + used.get(used.size()-1);
                    used.remove(used.size()-1);
                }
                else
                {
                    result = result + used.get(index-1);
                    used.remove(index-1);
                }

            }
            else
            {
                result = result + used.get(index) ;
                used.remove(index);
            }
        }
        for(int num:used)
        {
            result = result + num;
        }
        return result;
    }

    public static void main(String[] args)
    {
        int n = 3,k=3;
        Leetcode60 test = new Leetcode60();
        test.getPermutation(n,k);
    }
}
