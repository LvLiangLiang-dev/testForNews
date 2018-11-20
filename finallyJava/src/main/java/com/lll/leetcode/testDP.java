package com.lll.leetcode;
import java.util.*;
import static java.lang.Math.min;

/**
 * 感觉最重要的就是怎么将问题分成小问题
 *      主要是自下向上，但是具体到i，j不一定是从小到大
 *
 * Created by Fayne on 2017/12/26.
 */
public class testDP {
    public static void main(String[] args) {
        System.out.println(rob_dp());
    }
    /**
     * 198. House Robber    不能取相邻数值的条件下求取出最大的数值和
     *      1：递归，记忆化搜索
     *      2：DP
     *          从小到大，是从o开始还是从最大开始，要慎重考虑。
     *
     *      这个好像不是很清晰。。。。。。
     *
     *      money[i][0] = max(money[i - 1][0], money[i - 1][1])
        上述公式表示，不偷第 i 家房子，当前最大收益就是前一家房子的最大收益，前一家房子可能被偷了，也可能没有被偷。
        money[i][1] = money[i - 1][0] + nums[i]
        上述公式表示，要偷第 i 家的房子，必须在不偷第 i-1 家房子的前提下，才能加上偷第 i 家获得的收益。

        这个很好，比mook的好很多。。

        DP一定要找递归公式
     *
     *
     */
    private static void do_rob() {
        int[] arr = {7, 1, 5, 3, 8, 4, 1, 100};
        int n = arr.length;
        int memo[] = new int[n];
        for (int i = 0; i < n; i++)
            memo[i] = -1;
        System.out.println(rob(arr, memo, 0));
    }

    public int rob_dp_2(int[] nums) {
        if(nums.length==0||nums==null)return 0;
        int steal=nums[0];
        int not_steal=0;
        for(int i=1;i<nums.length;i++){
            int temp=not_steal;
            not_steal=Math.max(steal,not_steal);
            steal=temp+nums[i];
        }
        return steal>not_steal?steal:not_steal;
    }

    private static int rob_dp(){
        int[] nums = {7, 1, 5, 3, 8, 4, 1, 100};
        int n=nums.length;

        int rd[]=new int[n];
        rd[n-1]=nums[n-1];

        //[i,n-1]
        //
        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++)
                rd[i]=Math.max(rd[i],nums[j]+(j+2<n?rd[j+2]:0));
        return rd[0];
    }
    private static int rob(int[] arr,int []memo,int index) {
        if(index>=arr.length)return 0;
        int res=0;
        if(memo[index]!=-1)
            return memo[index];
        for(int i=index;i<arr.length;i++)
            res=Math.max(arr[index]+rob(arr,memo,i+2),res);
        memo[index]=res;
        return res;
    }

    /**
     * 53. Maximum Subarray     求最大连续子列和
     *      1：扫描法 o(n)o(1)
     *
     *      2：DP
     *          sum[i]=a[i]+sum[i-1]>0?sum[i-1],0;
     *          max=Math.max(sum[i],max)
     *      如果i-1小于0，则都是抛弃掉，当然也用max记录下了之前的最大值
     *          避免了都是负值的情况
     *
     *
     */
    public int maxSubArray(int[] nums) {
        int cur=0,max=Integer.MIN_VALUE,n=nums.length;
        if(n==0)return 0;
        for(int i=0;i<n;i++){
            cur+=nums[i];
            if(cur>max)
                max=cur;
            if(cur<0)
                cur=0;
        }
        return max;
    }
    /**
     * 747. Min Cost Climbing Stairs
     * 注意初始值和边界的设计
     * 然后后面循环中都要遵守这个定义
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length, costemp = -1;
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        int[] rd = new int[n + 1];
        rd[0] = cost[0];
        rd[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            if (i == n)
                costemp = 0;
            else
                costemp = cost[i];
            rd[i] = Math.min(rd[i - 1], rd[i - 2]) + costemp;
        }
        return rd[n];
    }

    /**
     * 121. Best Time to Buy and Sell Stock     fuck 这DP还超时，超NMB?
     * <p>
     * 高票答案为在线处理方法
     * 巧妙的地方在于将某俩个值差的最大值的求
     * 转换为相邻相减形成的新数组的最大子列和的求
     * 美其名曰Kadane's Algorithm  不过我也不知道在线处理方法是不是就是这个方法。
     */

    public int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[] Rd = new int[n];

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                Rd[i] = Max3(Rd[i], Rd[i - 1], prices[i] - prices[j]);
        return Rd[n - 1];

    }

    public static int Max3(int x, int y, int z) {
        int temp = Math.max(x, y);
        temp = Math.max(temp, z);
        return temp;
    }


    /**
     * 91. Decode Ways 1-26代表a-z 求一个数字组合替换成字符所代表的可能组合数。
     * 正确的解法参考了答案
     * 主要是record[0]=1的设计
     * =0的话，连最基础的都没有，不能加一
     * >10要考虑，不然可能是十位为0，第二个就不能加一
     */
    private static int q91(String s) {
        if (s.length() == 0) return 0;
        char[] temp = s.toCharArray();
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = Character.getNumericValue(temp[s.length() - 1 - i]);
        }
        if (s.length() == 1 && num[0] == 0) return 0;
        if (s.length() == 1 && num[0] != 0) return 1;

        int record[] = new int[s.length() + 1];
        if (num[0] == 0)
            record[0] = 0;
        else
            record[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i > 1) {
                if (num[i - 1] * 10 + num[i - 2] <= 26)
                    record[i] = record[i - 1] + record[i - 2];
                else
                    record[i] = record[i - 1];

            } else {
                if (num[i - 1] > 0)
                    record[i] = record[i - 1];
                else
                    record[i] = 0;
            }
        }
        return record[s.length()];
    }

    class Solution {
        public int numDecodings(String s) {
            if (s.length() == 0) return 0;
            char[] temp = s.toCharArray();
            int[] num = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                num[i] = Character.getNumericValue(temp[s.length() - 1 - i]);
            }

            int record[] = new int[s.length() + 1];
            record[0] = 1;
            if (num[0] == 0)
                record[1] = 0;
            else
                record[1] = 1;
            for (int i = 2; i <= s.length(); i++) {
                if (num[i - 1] * 10 + num[i - 2] >= 10 && num[i - 1] * 10 + num[i - 2] <= 26)
                    record[i] = record[i] + record[i - 2];
                if (num[i - 1] > 0)
                    record[i] = record[i] + record[i - 1];
            }
            return record[s.length()];
        }
    }

    /**
     * Q279 Perfect Squares     求最小的平方数的数量之和
     * <p>
     * DP
     * 注意初始值，要从0开始，我刚开始从1开始的，报错，因为后面有0的情况，但是0的值为最大值
     * <p>
     * 感觉都是俩个循环，只不过有一些微小的适应题目的变动。
     * 哼哼~
     * 而且DP是从底向上的思考，就是先思考1的情况，最终得到n的情况
     * 如果是记忆化搜索，顾名思义，就是要求得n的情况，慢慢的下降去思考。
     */
    private static int q279(int n) {
        int[] record = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            record[i] = Integer.MAX_VALUE;

        record[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                //i=j+i-j
                record[i] = min(record[i], 1 + record[i - j * j]);
        return record[n];
    }

    /**
     * 343. Integer Break   求n相加组成的相乘的最大值。
     * 1：递归
     * 2：记忆化搜索
     * 3：DP
     */
    private static void do_q343() {
        int n = 10;
        int record[] = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            record[i] = -1;

        int result = q343(10);
        int result2 = q343_2(record, n);
        int result3 = q343_3(n);
        System.out.println(result3);
    }

    private static int q343_3(int n) {
        int[] record = new int[n + 1];
        record[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i - 1; j++)
                //i=j+i-j;
                record[i] = max3(record[i], j * (i - j), j * record[i - j]);
        return record[n];
    }

    private static int q343_2(int[] record, int n) {
        if (n == 1) return 1;
        if (record[n] != -1) return record[n];
        int res = -1;
        for (int i = 1; i < n; i++)
            res = max3(res, i * q343(n - i), i * (n - i));
        record[n] = res;
        return res;
    }

    private static int q343(int n) {
        if (n == 1) return 1;
        int res = -1;
        for (int i = 1; i < n; i++)
            res = max3(res, i * q343(n - i), i * (n - i));
        return res;
    }

    private static int max3(int x, int y, int z) {
        int temp = Math.max(x, y);
        temp = Math.max(temp, z);
        return temp;
    }

    /**
     * 70. Climbing Stairs
     * 经典问题，通过DP的思想去考虑，在达到n步之前，有俩种可能n-1步然后走一步，或者是n-2步走俩步。
     *
     * @param n
     * @return
     */
    private static int question70(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++)
            arr[i] = arr[i - 1] + arr[i - 2];
        return arr[n];
    }

    /**
     * 120. Triangle
     * 很精妙的用一个数组，大小比最大的还要大一个，默认的是0
     * 一层一层不断的覆盖，类似于加上下一层的俩个。
     */
    public int question120(List<List<Integer>> triangle) {
        int result[] = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--)
            for (int j = 0; j < triangle.get(i).size(); j++)
                result[j] = min(result[j], result[j + 1]) + triangle.get(i).get(j);
        return result[0];
    }

    /**
     * question64
     * 我先是通过递归做的，但是超时了。
     * <p>
     * 后来用了DP，
     */
    class Solution64 {
        public int minPathSum(int[][] grid) {
            int length = grid.length;
            int wide = grid[0].length;
            int result = recu(grid, length - 1, wide - 1);
            return result;
        }

        public int recu(int[][] grid, int x, int y) {
            if (x == 0 && y == 0) return grid[0][0];
            else if (x == 0) {
                return recu(grid, x, y - 1) + grid[x][y];
            } else if (y == 0) {
                return recu(grid, x - 1, y) + grid[x][y];
            } else {
                return min(recu(grid, x, y - 1), recu(grid, x - 1, y)) + grid[x][y];
            }
        }
    }

    class Solution64_2 {
        public int minPathSum(int[][] grid) {
            int x = grid.length;
            int y = grid[0].length;
            int[][] sum = new int[x][y];
            sum[0][0] = grid[0][0];
            for (int i = 1; i < x; i++)
                sum[i][0] = sum[i - 1][0] + grid[i][0];
            for (int i = 1; i < y; i++)
                sum[0][i] = sum[0][i - 1] + grid[0][i];
            for (int i = 1; i < x; i++)
                for (int j = 1; j < y; j++)
                    sum[i][j] = min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            return sum[x - 1][y - 1];
        }
    }
}
