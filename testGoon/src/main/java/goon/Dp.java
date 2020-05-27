package goon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2020/5/8.
 */
public class Dp {
    public static void main(String[] args) {
        Dp dp = new Dp();

        int[][] A = new int[][] {{1, 2}, {4, 5}, {7, 8, 10, 11, 12}, {}};
        System.out.println(A.length);//4,表示数组的行数
        System.out.println(A[0].length);//2，表示对应行的长度
        System.out.println(A[1].length);//2
        System.out.println(A[2].length);//5

    }

    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * <p>
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * <p>
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * <p>
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：2
     * 输出：true
     * 解释：爱丽丝选择 1，鲍勃无法进行操作。
     * 示例 2：
     * <p>
     * 输入：3
     * 输出：false
     * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divisor-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param N
     *
     * @return
     */
    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }
        boolean[] rd = new boolean[N + 1];
        rd[1] = false;
        rd[2] = true;

        for (int i = 3; i < N + 1; i++) {
            rd[i] = false;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && rd[i - j] == false) {
                    rd[i] = true;
                    break;
                }
            }
        }
        return rd[N];
    }

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     *   [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     *
     * @return
     */

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 在LeetCode商店中， 有许多在售的物品。
     * <p>
     * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
     * <p>
     * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
     * <p>
     * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
     * <p>
     * 任意大礼包可无限次购买。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
     * 输出: 14
     * 解释:
     * 有A和B两种物品，价格分别为¥2和¥5。
     * 大礼包1，你可以以¥5的价格购买3A和0B。
     * 大礼包2， 你可以以¥10的价格购买1A和2B。
     * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
     * 示例 2:
     * <p>
     * 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
     * 输出: 11
     * 解释:
     * A，B，C的价格分别为¥2，¥3，¥4.
     * 你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
     * 你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
     * 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
     * 说明:
     * <p>
     * 最多6种物品， 100种大礼包。
     * 每种物品，你最多只需要购买6个。
     * 你不可以购买超出待购清单的物品，即使更便宜。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shopping-offers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param price
     * @param special
     * @param needs
     *
     * @return
     */

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 这个就是记忆化搜索用的记忆变量
        Map<List<Integer>,Integer> store = new HashMap<>();
        return cicrle(price, special, needs, store);
    }

    private int cicrle(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
                       Map<List<Integer>, Integer> store) {
        if(store.containsKey(needs)){
            return store.get(needs);
        }
        int i = 0;
        int res = getNoSpecialPrices(price, needs);
        for (List<Integer> oneSpecial : special) {
            List<Integer> clone = new ArrayList<>(needs);
            for (i = 0; i < needs.size(); i++) {
                int diff = clone.get(i) - oneSpecial.get(i);
                if (diff < 0) {
                    break;
                }
                clone.set(i, diff);
            }
            if (i == needs.size()) {
                res = Math.min(res, oneSpecial.get(i) + cicrle(price, special, clone, store));
            }

        }
        store.put(needs,res);
        return res;
    }

    private int getNoSpecialPrices(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < price.size(); i++) {
            sum += needs.get(i) * price.get(i);
        }
        return sum;
    }

    /**
     * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     *
     * 示例 1:
     *
     * 输入: [23,2,4,6,7], k = 6
     * 输出: True
     * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
     * 示例 2:
     *
     * 输入: [23,2,6,4,7], k = 6
     * 输出: True
     * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
     * 说明:
     *
     * 数组的长度不会超过10,000。
     * 你可以认为所有数字总和在 32 位有符号整数范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        return  false;

    }
}


