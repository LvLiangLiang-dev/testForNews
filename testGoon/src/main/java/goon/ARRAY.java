package goon;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2020/5/26.
 */
public class ARRAY {
    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public int maxSubArray(int[] nums) {
        if(1 == nums.length){
            return nums[0];
        }
        int [] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;

    }

    /**
     * 152. 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int tempMax = 1;
        int tempMin = 1;
        for(int i=0;i<nums.length-1;i++){
            tempMax = Math.max(tempMax*nums[i],nums[i]);
            tempMin = Math.min(tempMin*nums[i],nums[i]);
            max = Math.max(tempMax,Math.max(tempMin,max));
        }
        return max;
    }

    /**
     * 面试题 01.01. 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * 示例 1：
     *
     * 输入: s = "leetcode"
     * 输出: false
     * 示例 2：
     *
     * 输入: s = "abc"
     * 输出: true
     * 限制：
     *
     * 0 <= len(s) <= 100
     * 如果你不使用额外的数据结构，会很加分。
     */
    public boolean isUnique(String astr) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<astr.length();i++){
            char c = astr.charAt(i);
            int number = map.getOrDefault(c, 0) +1;
            map.put(c,number);
            if(number>1){
                return false;
            }
        }
        return true;
    }

    /**
     * 这里巧妙了运用了 位运算
     * 通过 一个int 0，实际上就是二进制中的32个0，用为运算加上这么多0来进表示不同位置是否出现过
     * 实际上这种位运算加上一个0，和 加上一个数组来判断 某种意义上是一样的。
     * @param astr
     * @return
     */

    public boolean isUnique2(String astr) {
        int record = 0;
        for(int i=0;i<astr.length();i++){
            int distance = ((int)astr.charAt(i) - (int)'a');
            if(((1 << distance) & record) != 0){
                return false;
            }
            record = record | (1<<distance);
        }
        return true;
    }

    public static void main(String[] args) {
        ARRAY array = new ARRAY();
        System.out.println(array.isUnique2("whsgy"));
        System.out.println((int)'b'-(int)'a');
    }

}
