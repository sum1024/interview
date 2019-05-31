public class Leetcode151 {
    public String reverseWords(String s) {
        if(s.length() <= 0)
        {
            return "";
        }
        String[] tmp = s.split(" ");
        String result = "";
        for(int i=tmp.length-1;i>=0;i--)
        {
            if(tmp[i].length() > 0)
            {
                result = result + tmp[i] + " ";
            }
        }
        if(result.length() > 1)
        {
            result = result.substring(0,result.length()-1);
        }
        return result;
    }
}
