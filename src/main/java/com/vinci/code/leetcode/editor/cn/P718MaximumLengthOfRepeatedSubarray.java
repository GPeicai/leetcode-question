//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//
//
// 示例：
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
//
//
//
//
// 提示：
//
//
// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100
//
// Related Topics 数组 哈希表 二分查找 动态规划
// 👍 339 👎 0


package com.vinci.code.leetcode.editor.cn;
//Java：最长重复子数组
public class P718MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findLength(int[] A, int[] B) {
            return A.length < B.length ? findMax(A, B) : findMax(B, A);
        }

        int findMax(int[] A, int[] B) {
            int max = 0;
            int an = A.length, bn = B.length;
            for(int len=1; len <= an; len++) {
                max = Math.max(max, maxLen(A, 0, B, bn - len, len));
            }
            for(int j=bn-an; j >= 0;j--) {
                max = Math.max(max, maxLen(A, 0, B, j, an));
            }
            for(int i=1;i<an;i++) {
                max = Math.max(max, maxLen(A, i, B, 0, an - i));
            }
            return max;
        }

        int maxLen(int[] a, int i, int[] b, int j, int len) {
            int count = 0, max = 0;
            for(int k = 0; k < len; k++) {
                if(a[i+k] == b[j+k]) {
                    count++;
                } else if(count > 0) {
                    max = Math.max(max, count);
                    count = 0;
                }
            }
            return count > 0 ? Math.max(max, count) : max;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
