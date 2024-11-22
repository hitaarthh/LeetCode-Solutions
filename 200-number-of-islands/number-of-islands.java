class Solution {
    public int numIslands(char[][] grid) {
        
        int numOfIsland = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if (grid[i][j] == '1')
                {
                    numOfIsland ++;
                    dfs(grid,i,j);
                }
            }
        }
        return numOfIsland;
    }

    public void dfs(char grid[][],int i, int j)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != '1')
        return;

        grid[i][j] = '2';

        dfs(grid, i+1,j);
        dfs(grid, i,j+1);
        dfs(grid, i-1,j);
        dfs(grid, i,j-1);
    }
}
