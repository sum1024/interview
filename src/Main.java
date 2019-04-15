
public class Main {
    public static void main(String[] args) {
        MilitaryTraining pf = new MilitaryTraining();
        pf.function();
    }
}

/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[m];
        for(int i=1;i<m;i++)
        {
            arr[i] = sc.nextLine();
        }
        arr[0] = sc.nextLine();
        int count = 0;
        boolean flag_stop = false;
        List<String> arrl1 = new ArrayList<String>();
        List<String> arrl2 = new ArrayList<String>();
        arrl1.add(arr[0]);
        for(int i=1;i<m;i++){
            if(i%2 == 1)
            {
                for(String st:arrl1) {
                    String[] tmp = st.split(arr[i]);
                    for (int j = 0; j < tmp.length - 1; j++) {
                        arrl2.add(tmp[j]);
                    }
                    count += tmp.length - 1;
                }
                arrl1.clear();
            }
            if(i%2 == 2)
            {
                for(String st:arrl2) {
                    String[] tmp = st.split(arr[i]);
                    for (int j = 0; j < tmp.length - 1; j++) {
                        arrl1.add(tmp[j]);
                    }
                    count += tmp.length - 1;
                }
                arrl2.clear();
            }
        }
        System.out.print(count);
    }
}*/

/*public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = new String(sc.nextLine());
        byte[] arrb = arr.getBytes();
        int flag = 0;
        int times = 1;
        for(;(times<arrb.length)&&(flag == 0);times++) {
            for (int i = 0; i < arrb.length; i++) {
                if (arrb[(times + i) % arrb.length] != arrb[i]) {
                    break;
                } else {
                    if (i == (arrb.length-1)) {
                        flag = 1;
                    }
                }
            }
        }
        System.out.print(times-flag);
    }
}*/


/*
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = new String(sc.nextLine());
        String B = new String(sc.nextLine());
        byte[] ab = A.getBytes();
        byte[] bb = B.getBytes();
        int times = sc.nextInt();
        int[] appear = new int[times];
        int l = 0;
        int r = 0;
        int addr = 0;
        for(int i= 0;i<times;i++)
        {
            l = sc.nextInt();
            r = sc.nextInt();
            addr = 0;
            for(int j=l-1; j<r;j++)
            {
                if(ab[j]==bb[addr])
                {
                    if(addr==(bb.length-1))
                    {
                        appear[i]++;
                        addr = 0;
                    }
                    else
                    {
                        addr++;
                    }
                }
                else {
                    addr = 0;
                }
            }
        }
        for(int i=0;i<times;i++)
        {
            System.out.println(appear[i]);
        }
    }
}
*/

/*import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = new String(sc.nextLine());
        byte[] bytes = n.getBytes();
        int count = 0;
        int str_sp = 0;
        int str_tt = 0;
        int addr = 0;
        for(int i = 1;i<bytes.length;i++)
        {
            if(bytes[addr] == bytes[i])
            {
                if(str_sp == 0)
                {
                    str_sp = str_tt;
                }
                str_sp--;
                if(str_sp == 0)
                {
                    count++;
                    addr = 0;
                }
                else
                {
                    addr++;
                }
            }
            else
            {
                str_tt ++;
                addr = 0;
            }
        }
        System.out.print(bytes.length/str_tt);
    }
}*/
        //头条 位移运算   没有通过
        /*        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int addr_s = 0;
        int addr_l = 0;
        int[] arr_small = new int[n];
        int[] arr_large = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] >= m)
                arr_large[addr_l++] = arr[i];
            else
                arr_small[addr_s++] = arr[i];
        }

        int count = 0;
        int tmp = 0;
        for (int j = 0; j < addr_s; j++) {
            for (int k = 0; k < addr_l; k++) {
                tmp = arr_small[j] ^ arr_large[k];
                if (tmp > m) {
                    count++;
                }
            }
        }
        for (int j = 0; j < addr_l; j++) {
            for (int k = j + 1; k < addr_l; k++) {
                tmp = arr_large[j] ^ arr_large[k];
                if (tmp > m) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}*/
        //头条校招2017  出题数
/*        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num == 1)
        {
            System.out.print("2");
            return;
        }
        int[] scores = new int[num];
        for(int i=0;i<num;i++)
        {
            scores[i] = sc.nextInt();
        }
        Arrays.sort(scores);
        int batch = 0;
        int more = 0;
        int d = 0;
        for(int i=0;i<num;i++)
        {
            batch = (batch+1)%3;
            if(i < num-1)
            {
                d = scores[i + 1] - scores[i];
            }
            else
            {
                break;
            }
            if(d>20)
            {
                more=more + (3 - batch);
                batch = 0;
            }
            else if(d>10)
            {
                if(batch == 0)
                {
                    more = more + 1;
                    i++;
                }
                if(batch == 1)
                {
                    more = more + 1;
                }
                batch = 0;
            }
        }
        if(batch!=0)
            more = more + (3-batch);
        System.out.print(more);*/
        //路灯
/*        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] ai = new int[n];
        for(int i = 0; i< n; i++)
        {
            ai[i]=sc.nextInt();
        }
        Arrays.sort(ai);
        int gap = ai[0]*2;
        int max_gap = gap;
        for(int i=1;i<n;i++)
        {
            gap = ai[i]-ai[i-1];
            if(gap > max_gap) {
                max_gap = gap;
            }
        }
        gap = (l - ai[n-1])*2;
        if(gap > max_gap)
        {
            max_gap = gap;
        }
        double d = max_gap/2.0;
        System.out.print(String.format("%.2f",d));*/
        //约德尔测试
/*        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        byte[] bytes1 = str1.getBytes();
        byte[] bytes2 = str2.getBytes();
        double percent = 0.0;
        int same_num = 0;
        for(int i=0;i<bytes1.length;i++)
        {
            if(((0x30 <= bytes1[i])&&(0x39>=bytes1[i]))||((0x41 <= bytes1[i])&&(0x5A>=bytes1[i]))||((0x61 <= bytes1[i])&&(0x7A>=bytes1[i])))
            {
                if(bytes2[i] == 0x31)
                    same_num++;
            }
            else
            {
                if(bytes2[i] == 0x30)
                    same_num++;
            }
        }
        percent = (same_num*1.0)/(bytes1.length*1.0);
        System.out.print(String.format("%.2f", percent*100)+"%");*/
        //反轉數組
    /*            Scanner sc = new Scanner(System.in);
                int int_len = sc.nextInt();
                if(int_len <= 0) {
                    System.out.println("no");
                    return;
                }
                if(int_len<=3)
                {
                    System.out.println("yes");
                    return;
                }
                int[] arr = new int[int_len];
                int flag = 0;
                for(int i=0; i< int_len;i++)
                {
                    arr[i] = sc.nextInt();
                }
                int first_angle = -1;
                int second_angle = -1;
            for(int j = 2; j<int_len;j++)
            {
                if(arr[j-2]<arr[j-1]&&arr[j-1]>arr[j])
                {
                    flag++;
                    if(flag == 1)
                    {
                        second_angle = j-1;
                    }
                    else
                    {
                        if(arr[j-1] > arr[first_angle-1]) {
                            flag++;
                            break;
                        }
                    }
                }
                else if(arr[j-2]>arr[j-1]&&arr[j-1]<arr[j])
                {
                    flag++;
                    if(flag == 1)
                    {
                        first_angle = j-1;
                    }
                    else
                    {
                        if(arr[j-1] < arr[second_angle-1])
                        {
                            flag++;
                            break;
                        }
                    }
                }
            }

            if(flag == 1)
            {
                if(first_angle != -1)
                {
                    if((arr[first_angle-1] < arr[int_len-1])&&(arr[first_angle+1] < arr[0]))
                    {
                        flag = 3;
                    }
                }
                else if(second_angle != -1)
                {
                    if((arr[second_angle-1] > arr[int_len-1])&&(arr[second_angle+1] > arr[0]))
                    {
                        flag = 3;
                    }
                }
            }

            if(flag > 2)
            {
                System.out.println("no");
                return;
            }
            else
            {
                System.out.println("yes");
                return;
            }
*/
        //股神
/*        Scanner sc = new Scanner(System.in);
        int day_num = sc.nextInt();
        int price = 0;
        int down_num = 0;
        int decreas = 0;
        while(day_num>0)
        {
            down_num = (int)Math.sqrt(day_num*2);
            if((down_num*(down_num+1))<=(2*day_num))
                decreas = 2*(down_num-1);
            else
                decreas = 2*(down_num-2);
            price = day_num-decreas;
            System.out.println(price);
            day_num = sc.nextInt();
        }*/
//    }
//}
