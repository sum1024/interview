/*
* leetcode 3 最长子串 (头条)
* 使用滑动窗口
* */
public class LongestSubstrin {
    public int lengthOfLongestSubstring(String s) {
        int[] loc = new int[128];
        int length = 0;
        char[] letters = s.toCharArray();
        for(int j=0,i=0;j<letters.length;j++) {
            i=Math.max(loc[letters[j]],i);
            length = Math.max(length,j-i+1);
            loc[letters[j]] = j+1;
        }
        return length;
    }

    public static  void main(String[] args)
    {
        LongestSubstrin ls= new LongestSubstrin();
        ls.lengthOfLongestSubstring("abcabcbb");
    }
}

