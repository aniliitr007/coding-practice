package com.akgcloud.geeksforgeeks;

public class IslandCounter {
    private final int   ROW_COUNT = 5;
    private final int   COL_COUNT = 5;
    private int[]       rowNbr    = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private int[]       colNbr    = { -1, 0, 1, -1, 1, -1, 0, 1 };
    private boolean[][] visited   = new boolean[ROW_COUNT][COL_COUNT];;

    public boolean isSafe(int[][] M, int row, int col) {
        if (row > -1 && row < ROW_COUNT && col > -1 && col < COL_COUNT && M[row][col] == 1
                && visited[row][col] == false) {
            return true;
        }
        return false;
    }

    public void dfs(int[][] M, int row, int col) {
        visited[row][col] = true;
        System.out.println(row + ", " + col);
        for (int i = 0; i < 8; i++) {
            if (isSafe(M, row + rowNbr[i], col + colNbr[i])) {
                dfs(M, row + rowNbr[i], col + colNbr[i]);
            }
        }
    }

    public int getIslandCount(int[][] M) {
        int count = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COL_COUNT; j++) {
                if (M[i][j] == 1 && visited[i][j] == false) {
                    dfs(M, i, j);
                    count++;
                    System.out.println("count : " + count);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 0, 0, 0 }, 
                        { 0, 1, 0, 0, 1 }, 
                        { 1, 0, 0, 1, 1 }, 
                        { 0, 0, 0, 0, 0 }, 
                        { 1, 0, 1, 0, 1 } };
        
        IslandCounter count = new IslandCounter();
        System.out.println("Island Count : " + count.getIslandCount(mat));;
        
        boolean[] x = new boolean[3];
        System.out.println(x[0] == false);

    }

}
