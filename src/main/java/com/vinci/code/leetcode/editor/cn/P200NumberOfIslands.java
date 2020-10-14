//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 792 👎 0


package com.vinci.code.leetcode.editor.cn;
//Java：岛屿数量
public class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));

        grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(solution.numIslands(grid));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int rn;
        private int cn;

        public int numIslands(char[][] grid) {
            rn = grid.length;
            if (rn == 0) return 0;
            cn = grid[0].length;
            int count = 0;
            for (int r=0; r<rn; r++) {
                for (int c=0; c<cn; c++) {
                    if (grid[r][c] == '1') {
                        count++;
                        DFSMarking(grid, r, c);
                    }
                }
            }
            return count;
        }

        private void DFSMarking(char[][] grid, int r, int c) {
            if (r<0 || r>=rn || c<0 || c>=cn || grid[r][c]!='1') return;
            grid[r][c] = '0';
            DFSMarking(grid, r-1, c);
            DFSMarking(grid, r+1, c);
            DFSMarking(grid, r, c-1);
            DFSMarking(grid, r, c+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}