import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MilitaryTraining {
    public void function(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n+1];
        List<Integer> num_left = new ArrayList<Integer>();
        for(int i=1;i<n+1;i++)
        {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        String out = "";
        int flag = 0;
        int remain = 0;
        for(int i = 1; i<=n; i++) {
            out = "1";
            num_left.clear();
            flag = 0;
            for(int j = 0;j<nums[i];j++)
            {
                num_left.add(j+1);
            }
            while(num_left.size() > 3) {
                if(flag == 0)
                {
                    count = 1;
                    while(count < num_left.size())
                    {
                        num_left.remove(count);
                        count += 1;
                    }
                }
                if(flag == 1)
                {
                    count = 2;
                    while(count < num_left.size())
                    {
                        num_left.remove(count);
                        count += 2;
                    }
                }
                flag = (flag + 1)%2;
            }
            for(int num:num_left)
            {
                if(num != 1)
                {
                    out += " "+ num;
                }
            }
            System.out.println(out);
        }
    }
}
