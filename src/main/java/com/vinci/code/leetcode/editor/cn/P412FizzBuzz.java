//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 72 👎 0


package com.vinci.code.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Fizz Buzz
public class P412FizzBuzz{
    public static void main(String[] args) {
        Solution solution = new P412FizzBuzz().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i=1; i<=n; i++ ){
            String s = "";
            if (i % 3 == 0) {
                s += "Fizz";
            }
            if (i % 5 == 0) {
                s += "Buzz";
            }
            if (s.isEmpty()) {
                s = String.valueOf(i);
            }
            list.add(s);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}