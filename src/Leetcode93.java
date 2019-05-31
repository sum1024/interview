import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    List<String> result = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {

        if(s.length()<4 || s.length()>12)
        {
            return result;
        }
        getIP(s,1,"");
        return result;
    }

    public void getIP(String s,int index,String ip) {
        if (s.length() <= 0) {
            return;
        }
        String tmp = "";
        if(index == 4)
        {
            if(s.length()>1 && s.charAt(0) == '0')
            {
                return;
            }
            if(0<=(Integer.parseInt(s)) && (Integer.parseInt(s))<=255)
            {
                String res = ip+"."+s;
                result.add(res.substring(1,res.length()));
                return;
            }
            else
            {
                return;
            }
        }
        for(int len=1;len<=3;len++)
        {
            if(len>1 && s.charAt(0)=='0')
            {
                return;
            }
            if((s.length() - len)<(4-index) || (s.length()-len) > 3*(4-index))
            {
                continue;
            }
            tmp = s.substring(0,len);
            try
            {
                int tmpi = Integer.parseInt(tmp);
                if(0<=tmpi && tmpi<=255)
                {
                    String res = ip+"."+tmp;
                    getIP(s.substring(len,s.length()),index+1,res);
                }
                else
                {
                    return;
                }
            }
            catch (Exception e)
            {
                return;
            }
        }
    }

    public static void main(String[] args)
    {
        Leetcode93 test = new Leetcode93();
        String str = "25525511135";
        test.restoreIpAddresses(str);
    }
}
