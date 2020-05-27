package goon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2020/5/26.
 */
public class RECALL {
    public static void main(String[] args) {
        RECALL recall = new RECALL();
        System.out.println(Arrays.toString(recall.permutation("aab")));

    }
    /**
     * 216. 组合总和 III
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * 说明：
     *
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     *
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     *
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     */
    /**
     * 回溯
     *  需要用栈这个数据结构
     *  需要递归这个结果
     *  可以剪枝，就是提前结束一轮循环
     *
     *  要先设好结束条件
     *  然后进入递归的条件和操作
     */
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        Stack<Integer> one = new Stack<>();
        recall(1,n,k,one);
        return res;
    }
    public void recall(int start, int rest, int num,Stack<Integer> one){
        if(rest == 0 && num == 0){
            res.add(new ArrayList<>(one));
            return;
        }
        for(int i= start;i<=9;i++){
            one.push(i);
            recall(i+1,rest-i,num-1,one);
            one.pop();
        }
    }

    /**
     * 46. 全排列
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     */
    List<List<Integer>> res2 = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        boolean [] record = new boolean[nums.length];
        recall2(0,nums,new Stack<>(),record);
        return res2;
    }
    public void recall2(int depth, int[] nums, Stack<Integer> stack, boolean[] record){
        if(depth == nums.length){
            res2.add(new ArrayList<>(stack));
        }
        for(int i=0;i<nums.length;i++){
            if(!record[i]){
                stack.push(nums[i]);
                record[i] = true;
                recall2(depth+1,nums,stack,record);
                record[i] = false;
                stack.pop();
            }
        }
    }

    /**
     * 面试题38. 字符串的排列
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     *
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     *
     *
     * 示例:
     *
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *
     *
     * 限制：
     *
     * 1 <= s 的长度 <= 8
     */

    public String[] permutation(String s) {
        Set<String> res = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        boolean [] record = new boolean[s.length()];
        recall3(0,s,stack,res,record);
        String [] resString = new String[res.size()];
        List<String> resList = new ArrayList<>(res);
        for(int i=0;i<resList.size();i++){
            resString[i] = resList.get(i);
        }
        return resString;
    }
    public void  recall3(int depth, String s, Stack<Character> stack, Set<String> res, boolean[] record){
        if(depth == s.length()){
            String temp = "";
            for(int i=0;i<stack.size();i++){
                temp += String.valueOf(stack.get(i));
            }
            res.add(temp);
        }
        for(int i=0;i<s.length();i++){
            if(!record[i]){
                stack.push(s.charAt(i));
                record[i] = true;
                recall3(depth+1,s,stack,res,record);
                record[i] = false;
                stack.pop();
            }
        }
    }

}
