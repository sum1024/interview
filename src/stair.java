/*
* 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或二级，要走上第m级，共有多少走法？

注：规定从一级到一级有0种走法。
输入
输入数据首先包含一个整数n(1<=n<=100)，表示测试实例的个数，然后是n行数据，每行包含一个整数m，（1<=m<=40), 表示楼梯的级数。
输出
对于每个测试实例，请输出不同走法的数量。

样例输入
2

2

3

样例输出
1

2


*/

import java.util.ArrayList;
import java.util.Scanner;

public class stair {
    public void functions() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int num = 0;
        int[] result = new int[41];
        result[1] = 1;
        result[2] = 1;
        max = 2;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            if(num == 1)
            {
                System.out.println(""+0);
            }
            else
            {
                while(max < num)
                {
                    result[max+1] = result[max] + result[max-1];
                    max++;
                }
                System.out.println(""+result[num]);
            }
        }
    }
}