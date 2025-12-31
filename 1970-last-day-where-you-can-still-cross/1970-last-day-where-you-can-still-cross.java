class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length-1;
        int ans=0;
        while(left<=right){
            int mid = left + (right - left ) /2;
            if(isCross(mid,cells,row,col)){
                ans = mid;
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return ans+1;
    }

    public boolean isCross(int day , int[][] cells, int row,int col){
        int[][] matrix = new int[row][col];
        for(int i=0;i<=day;i++){
            matrix[cells[i][0]-1][cells[i][1]-1] = 1;
        }
        Queue<List<Integer>> curr_queue = new LinkedList<>();
        for(int c=0;c<col;c++){
            if(matrix[0][c] == 0){
                curr_queue.offer(List.of(0,c));
            }
        }
        int[][] directions = {{0,1},{-1,0},{1,0},{0,-1}};
        boolean[][] visited = new boolean[row][col];
        while(!curr_queue.isEmpty()){
            List<Integer> curr = curr_queue.poll();
            for(int[] dir : directions ){
                int x = curr.get(0) + dir[0];
                int y = curr.get(1) + dir[1];
                if(x<row && y<col && x>-1 && y>-1 && matrix[x][y] == 0 && !visited[x][y]){
                    if(x == row-1) return true;
                    visited[x][y] = true;
                    curr_queue.offer(List.of(x,y));
                }
            }
        }
        return false;
        
    }
}