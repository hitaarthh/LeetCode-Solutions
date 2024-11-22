class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int vis[][] = new int[grid.length][grid[0].length];
        int freshCount = 0;
        for(int i = 0; i < grid.length; i++) 
            for(int j = 0; j < grid[0].length; j++) 
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = 1;
                } 
                else if(grid[i][j] == 1) 
                    freshCount++;
        int maxTime = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int i = node[0];
            int j = node[1];
            int time = node[2];
            maxTime = Math.max(maxTime, time);
            for(int[] dir: directions) {
                int newRow = i + dir[0];
                int newCol = j + dir[1];
                if (newRow >= 0 && newRow < grid.length && 
                    newCol >= 0 && newCol < grid[0].length && 
                    vis[newRow][newCol] == 0 && 
                    grid[newRow][newCol] == 1) 
                    {
                        q.add(new int[]{newRow, newCol, time + 1});
                        vis[newRow][newCol] = 1;
                        freshCount--;
                    }
            }
        }
        return freshCount == 0 ? maxTime : -1;
    }
}