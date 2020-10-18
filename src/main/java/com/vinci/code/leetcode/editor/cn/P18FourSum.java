//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 652 👎 0


package com.vinci.code.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和
public class P18FourSum{
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int index1=0; index1<n-3; index1++) {
            if (index1 > 0 && nums[index1] == nums[index1-1]){
                continue;
            }
            if (nums[index1] + nums[index1+1] + nums[index1+2] + nums[index1+3] > target) {
                break;
            }
            if (nums[index1] + nums[n-1] + nums[n-2] + nums[n-3] < target) {
                continue;
            }

            for (int index2=index1+1; index2<n-2; index2++) {
                if (index2 > index1+1 && nums[index2]==nums[index2-1]) {
                    continue;
                }
                if (nums[index1] + nums[index2] + nums[index2+1] + nums[index2+2] > target) {
                    break;
                }
                if (nums[index1] + nums[index2] + nums[n-1] + nums[n-2] < target) {
                    continue;
                }

                int index3 = index2+1;
                int lastIndex = n-1;
                while (index3 < lastIndex) {
                    if (nums[index1] + nums[index2] + nums[index3] + nums[lastIndex] == target) {
                        res.add(Arrays.asList(nums[index1], nums[index2], nums[index3], nums[lastIndex]));
                        index3++;
                        while (index3<lastIndex && nums[index3]==nums[index3-1]) {
                            index3++;
                        }
                        lastIndex--;
                        while (index3<lastIndex && nums[lastIndex]==nums[lastIndex+1]) {
                            lastIndex--;
                        }
                    }else if (nums[index1] + nums[index2] + nums[index3] + nums[lastIndex] > target) {
                        lastIndex--;
                    }else {
                        index3++;
                    }
                }
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}