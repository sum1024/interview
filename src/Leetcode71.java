import java.util.ArrayList;
import java.util.List;

public class Leetcode71 {
    public String simplifyPath(String path) {
        String result = "";
        if(path.length()<=0)
        {
            return result;
        }
        List<String> part = new ArrayList<String>();
        String[] tmp = path.split("/");
        for(String str:tmp)
        {
            if(str.length()>0)
            {
                if(str.equals("."))
                {
                    continue;
                }
                else if(str.equals(".."))
                {
                    if(part.size() >=1 )
                    {
                        part.remove(part.size()-1);
                    }
                }
                else
                {
                    part.add(str);
                }
            }
        }
        if(part.size() == 0)
        {
            result = "/";
        }
        for(String str:part)
        {
            result = result+"/"+str;
        }
        return result;
    }
}
