package goon;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2020/5/21.
 */
public class DFS {
    /**
     * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * 输出：15
     *  
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在 1 到 10^4 之间。
     * 每个节点的值在 1 到 100 之间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    int sum = -1;
    int max = -1;

    public int deepestLeavesSum(TreeNode root) {
        cal(root, 0);
        return sum;
    }

    private void cal(TreeNode root, int dep) {
        if (null == root) {
            return;
        }
        if (null == root.left && null == root.right) {

            if (dep > max) {
                max = dep;
                sum = root.val;
            } else if (dep == max) {
                sum += root.val;
            }
        }
        cal(root.left, dep + 1);
        cal(root.right, dep + 1);
    }

    /**
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 需要注意引用和新的变量之间的区别
     *
     * @param root
     * @param sum
     *
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        cal2(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void cal2(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> route) {
        if (root == null) {
            return;
        }
        route.add(root.val);
        if (null == root.left && null == root.right) {
            int all = 0;
            for (int one : route) {
                all += one;
            }
            if (all == sum) {
                res.add(route);
            }
            return;
        }
        cal2(root.left, sum, res, new ArrayList<>(route));
        cal2(root.right, sum, res, new ArrayList<>(route));
    }

    /**
     * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
     * <p>
     * 如果指定节点没有对应的“下一个”节点，则返回null。
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [2,1,3], p = 1
     * <p>
     * 2
     * / \
     * 1   3
     * <p>
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: root = [5,3,6,2,4,null,null,1], p = 6
     * <p>
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * <p>
     * 输出: null
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/successor-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 这一题用这种方法没什么意义，就是通过中序遍历获得结果，
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> res = new ArrayList<>();
        helper(root, res);
        for(int i=0;i<res.size();i++){
            if(res.get(i).equals(p)){
                if(i+1<res.size()){
                    return res.get(i+1);
                }
            }
        }
        return null;
    }

    private void helper(TreeNode root, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root);
        if (root.right != null) {

            helper(root.right, res);
        }
    }

}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}