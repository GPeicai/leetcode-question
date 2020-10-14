//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9105 👎 0


package com.vinci.code.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：两数之和
public class P1TwoSum{
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        int[] nums = new int[]{1,3,4,6,9};
        System.out.println(Arrays.toString(solution.twoSum(nums, 7)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int first = target - nums[i];
            if(map.containsKey(first)) {
                return new int[]{map.get(first), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("not exist two sum");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}