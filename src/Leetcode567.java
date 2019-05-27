/*
* leetcode567 字符串的排列
* */
public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() <= 0 || s2.length()<=0 || s1.length()>s2.length())
        {
            return  false;
        }
        int[][] substr = new int[2][26];
        char[] s1_c = s1.toCharArray();
        char[] s2_c = s2.toCharArray();
        int addr = 0;
        for(char c:s1_c)
        {
            addr = c - 'a';
            substr[0][addr]++;
            substr[1][addr]++;
        }
        int jump = 0;
        for(int i = 0;i<=(s2_c.length-s1_c.length);)
        {
            for(int j=0;(i+j)<s2_c.length;j++)
            {
                addr = s2_c[i+j] - 'a';
                if(substr[1][addr] > 0)
                {
                    substr[1][addr]--;
                    if(j == (s1_c.length-1))
                    {
                        return true;
                    }
                }
                else if(substr[1][addr] == 0)
                {
                    if(substr[0][addr] == 0)
                    {
                        for(int k = 0;k<26;k++) {
                            substr[1][k] = substr[0][k] ;
                        }
                        i = i + j +1;
                        break;
                    }
                    else
                    {
                        for(int k = 0;k<j;k++)
                        {
                            if(s2_c[i+k] != s2_c[i+j]) {
                                addr = s2_c[i + k] - 'a';
                                substr[1][addr]++;
                            }
                            else
                            {
                                i = i + k + 1;
                                j = j - k - 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String [] args)
    {
        Leetcode567 test = new Leetcode567();
        test.checkInclusion("rokx", "otrxvfszxroxrzdsltg");
    }
}
