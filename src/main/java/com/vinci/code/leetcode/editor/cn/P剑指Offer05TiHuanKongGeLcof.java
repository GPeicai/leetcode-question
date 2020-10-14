//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 44 👎 0


package com.vinci.code.leetcode.editor.cn;
//Java：替换空格
public class P剑指Offer05TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指Offer05TiHuanKongGeLcof().new Solution();
        // TO TEST
        String s = "wo shi zhongguoren";
        System.out.println(solution.replaceSpace(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}