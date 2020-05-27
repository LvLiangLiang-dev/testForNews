package goon;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2020/5/19.
 */

/**
 * 二分查找也称折半查找（Binary
 * Search
 * ），它是一种效率较高的查找方法，前提是数据结构必须先排好序，可以在数据规模的对数时间复杂度内完成查找。但是，二分查找要求线性表具有有随机访问的特点（例如数组），也要求线性表能够根据中间元素的特点推测它两侧元素的性质，以达到缩减问题规模的效果。
 *
 * 链接：https://leetcode-cn.com/tag/binary-search/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Bp {
    public static void main(String[] args) {

    }
    /**
     *我们把符合下列属性的数组 A 称作山脉：
     *
     * A.length >= 3
     * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[0,1,0]
     * 输出：1
     * 示例 2：
     *
     * 输入：[0,2,1,0]
     * 输出：1
     *  
     *
     * 提示：
     *
     * 3 <= A.length <= 10000
     * 0 <= A[i] <= 10^6
     * A 是如上定义的山脉
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int peakIndexInMountainArray(int[] A) {
        int left= 0;
        int right = A.length-1;
        int mid = 0 ;
        while (left<right){
            mid = (left +right)/2;
            if(A[mid]>A[mid-1] && A[mid]>A[mid+1]){
                return mid;
            }
            if(A[mid]>A[mid-1] && A[mid]<A[mid+1]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;

    }

    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     *
     * 示例 1:
     *
     * 输入: [1,3,4,2,2]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [3,1,3,4,2]
     * 输出: 3
     * 说明：
     *
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 这一题非常棒，通过BP和抽屉原理查询重复的个数
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left<right){
            int cnt = 0;
            mid = left + (right-left)/2;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid){
                    cnt++;
                }
            }
            if(cnt>mid){
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return left;
    }
}
