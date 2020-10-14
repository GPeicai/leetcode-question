//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索
// 👍 472 👎 0


package com.vinci.code.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：单词接龙
class P127WordLadder{
    public static void main(String[] args) {
        Solution solution = new P127WordLadder().new Solution();
        // TO TEST
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArr = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(wordArr);
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> sets = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i=0; i<chars.length; i++) {
                    for (char c='a'; c<='z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        //String target = chars.toString();
                        String target = String.valueOf(chars);
                        if (endSet.contains(target)) {
                            return step + 1;
                        }

                        if (dict.contains(target) && !visited.contains(target)) {
                            visited.add(target);
                            sets.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = sets;
            step++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
