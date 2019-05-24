import java.util.List;
import java.util.SimpleTimeZone;

public class Leetcode14 {
    class TrieNode{
        char val;
        int end;
        TrieNode children;
        TrieNode(char v)
        {
            val = v;
            end = 0;
        }
        public void insertStr(TrieNode root,String str)
        {
            if(root == null || str == null)
            {
                return;
            }
            TrieNode node = root;
            char[] letters = str.toCharArray();
            for(int i =0;i<letters.length;i++)
            {
                if(node.end == 1)
                {
                    break;
                }
                if(node.children == null)
                {
                    node.children = new TrieNode(letters[i]);
                }
                else
                {
                    if(node.children.val != letters[i])
                    {
                        node.end = 1;
                        return;
                    }
                }
                node = node.children;
            }
            node.end = 1;
        }
        public String getLongestPrefix(TrieNode root)
        {
            if(root == null ||root.end == 1||root.children != null)
            {
                return "";
            }
            if(root.children.end ==1 )
            {
                return ""+root.children.val;
            }
            else
            {
                return ""+root.children.val+getLongestPrefix(root.children);
            }
        }
    }
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode('\0');
        for(String str:strs)
        {
            root.insertStr(root,str);
        }
        return root.getLongestPrefix(root);
    }

    public static void main(String[] args)
    {
        Leetcode14 l = new Leetcode14();
        String[] str = new String[2];
        str[0] = "";
        str[1] ="b";
        l.longestCommonPrefix(str);
    }
}
