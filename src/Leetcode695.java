public class Leetcode695 {
    int[][] flag;
    int max = 0;
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        flag = new int[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[i].length;j++)
            {
                if(grid[i][j] == 1)
                {
                    count = 0;
                    getDeeper(grid,i,j);
                }
            }
        }

        return max;
    }

    public void getDeeper(int [][] grid,int l,int c)
    {
        if(grid[l][c] == 0 || flag[l][c] == 1)
        {
            return;
        }
        count++;
        if(count > max)
        {
            max = count;
        }
        flag[l][c]=1;
        if((l-1)>=0)
        {
            getDeeper(grid,l-1,c);
        }
        if((l+1)<grid.length)
        {
            getDeeper(grid,l+1,c);
        }
        if((c-1)>=0)
        {
            getDeeper(grid,l,c-1);
        }
        if((c+1)<grid[l].length)
        {
            getDeeper(grid,l,c+1);
        }
    }
}
