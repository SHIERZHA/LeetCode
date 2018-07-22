class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> rs = new ArrayList<List<String>>();
        int[][] mark = new int[n][n];
        List<String> location = new ArrayList<String>();
        
        for(int i = 0; i < n; i++){
            String line = "";
            for(int j = 0; j < n; j++){
                mark[i][j] = 0;
                line = line + ".";
            }
            location.add(line);
        }
        
        backtrack(rs, 0, location, n, mark);
        return rs;
        
    }
    
    public void putQueens(int x, int y, int[][] m){
        
        m[x][y] = 1;
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; //方向数组，8个方向
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
        int length = m.length;
        
        for(int i = 1; i < length; i++){
            for(int j = 0; j < 8; j++){
                int newX = x + i * dx[j];
                int newY = y + i * dy[j];
                if(newX >= 0 && newX < length && newY >= 0 && newY < length){
                    m[newX][newY] = 1;
                }
            }
        }
        
    }
    

    public void backtrack(List<List<String>> rs, int lineNum, List<String> location, int N, int[][] mark){
        
        if(lineNum == N){
            rs.add(new ArrayList<String>(location)); // if not new an new arraylist, the change of location will change the arraylist in the rs
            return;
        }
        else{
            for(int i = 0; i < N; i++){
                if(mark[lineNum][i] == 0){
                    int[][] formerMark = new int[N][N]; //two-dimension arrays, use for to deep clone
                    for(int m = 0; m < N ; m++){
                        formerMark[m] = Arrays.copyOf(mark[m],mark[m].length);
                    }
                    putQueens(lineNum, i, mark);
                    
                    StringBuilder sb = new StringBuilder(location.get(lineNum));
                    String tmpSb = sb.toString();
                    sb.setCharAt(i,'Q');
                    String sbChanged = sb.toString();
                    location.set(lineNum, sbChanged); 
                    
                    backtrack(rs, lineNum + 1, location, N, mark);
                    
                    location.set(lineNum, tmpSb);
                    mark = formerMark;
                }
            }
        }
        
    }
    
    
}