/*
*
* 击鼓传花


									题目描述

学校联欢晚会的时候，为了使每一个同学都能参与进来，主持人常常会带着同学们玩击鼓传花的游戏。
游戏规则是这样的：n个同学坐着围成一个圆圈，指定一个同学手里拿着一束花，
主持人在旁边背对着大家开始击鼓，鼓声开始之后拿着花的同学开始传花，
每个同学都可以把花传给自己左右的两个同学中的一个（左右任意），
当主持人停止击鼓时，传花停止，此时，正拿着花没传出去的那个同学就要给大家表演一个节目。
聪明的小赛提出一个有趣的问题：有多少种不同的方法可以使得从小赛手里开始传的花，
传了m次以后，又回到小赛手里。
对于传递的方法当且仅当这两种方法中，接到花的同学按接球顺序组成的序列是不同的，才视作两种传花的方法不同。
比如有3个同学1号、2号、3号，并假设小赛为1号，花传了3次回到小赛手里的方式有1->2->3->1和1->3->2->1，共2种。
*/



import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class PassFlower {
    public void function(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(m == 0)
        {
            System.out.print(1);
            return;
        }
        if(m == 1)
        {
            System.out.print(0);
            return;
        }
        int dp[][] = new int[m+1][n+1];
        dp[0][1] = 1;
        int tmp = -1;
        for(int i = 1; i <= m; i++)
        {
           for(int j =1;j <=n; j++)
           {
               tmp = dp[i-1][j];
               if(tmp > 0)
               {
                   if(j == n) {
                       dp[i][1] += dp[i - 1][j];
                       dp[i][j-1] += dp[i - 1][j];
                   }
                   else if(j == 1)
                   {
                       dp[i][j+1] += dp[i - 1][j];
                       dp[i][n] += dp[i - 1][j];
                   }
                   else {
                       dp[i][j + 1] += dp[i - 1][j];
                       dp[i][j - 1] += dp[i - 1][j];
                   }
               }
           }
        }
        System.out.print(dp[m][1]);
    }
}
