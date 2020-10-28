//给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
//
//
//
// 示例：
//
// 输入：S = "ADOBECODEBANC", T = "ABC"
//输出："BANC"
//
//
//
// 提示：
//
//
// 如果 S 中不存这样的子串，则返回空字符串 ""。
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 804 👎 0


package com.vinci.code.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
        String s = "abcdefgadgsdfs";
        String t = "gfd";
        System.out.println(solution.minWindow(s,t));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        Map<Character, Integer> ori = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i=0; i<tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c,0) + 1);
        }
        int left = 0, right = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (right < sLen) {
            right ++ ;
            if (right<sLen && ori.containsKey(s.charAt(right))) {
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0)+1);
            }
            while (check() && left<=right) {
                if (right-left+1 < len) {
                    len = right-left+1;
                    ansL = left;
                    ansR = left+len;
                }
                if (ori.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left),cnt.getOrDefault(s.charAt(left),0)-1);
                }
                left++;
            }
        }
        return ansL==-1 ? "" : s.substring(ansL, ansR);
    }

        private boolean check() {
            Iterator iter = ori.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry)iter.next();
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if (cnt.getOrDefault(key, 0) < val) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
