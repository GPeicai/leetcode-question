//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1:
//
//
//输入: "aba"
//输出: True
//
//
// 示例 2:
//
//
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
//
//
// 注意:
//
//
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
//
// Related Topics 字符串
// 👍 281 👎 0


package com.vinci.code.leetcode.editor.cn;
//Java：验证回文字符串 Ⅱ
public class P680ValidPalindromeIi{
    public static void main(String[] args) {
        Solution solution = new P680ValidPalindromeIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        while (low < high) {
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            }else {
                boolean flag1 = true;
                boolean flag2 = true;
                for (int i=low, j=high-1; i<j; i++,j--) {
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i=low+1,j=high; i<j; i++,j--) {
                    char c3 = s.charAt(i);
                    char c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
