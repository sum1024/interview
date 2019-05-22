/*
* leetcode
* 113 路径总和 2
*
* */

import java.util.*;

public class Pathsum {
    List<Integer> one = new ArrayList<Integer>();
    List<List<Integer>> total = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getPath(root,sum,0);
        return total;
    }
    public void getPath(TreeNode root,int sum,int current_sum)
    {
        if(root == null)
        {
            return;
        }
        current_sum += root.val;
        one.add(root.val);

        if(sum == current_sum)
        {
            if(root.left == null && root.right == null)
            {
                List<Integer> tmp = new ArrayList<Integer>(one);
                total.add(tmp);
            }
        }
        if(root.left != null)
        {
            getPath(root.left,sum,current_sum);
        }
        if(root.right != null)
        {
            getPath(root.right,sum,current_sum);
        }
        one.remove(one.size()-1);
    }
}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
         val = x;
     }
 };
