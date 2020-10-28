//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1384 👎 0


package com.vinci.code.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        List<String> res = solution.generateParenthesis(3);
        for (String s : res) {
            System.out.println(s);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

        private void dfs(int left, int right, String curStr) {
            if (left==0 && right==0) {
                res.add(curStr);
                return;
            }

            if (left > 0) {
                dfs(left-1, right, curStr+"(");
            }

            if (right > left) {
                dfs(left, right-1, curStr+")");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
