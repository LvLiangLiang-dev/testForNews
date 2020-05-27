package goon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author lvliangliang
 * @create 2020/5/22.
 */
public class BST {
    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     *  
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.add(root);
        int level = 0;
        while(!levelQueue.isEmpty()){
            res.add(new ArrayList<Integer>());
            int oneLevelSize = levelQueue.size();
            for(int i=0;i<oneLevelSize;i++){
                TreeNode now = levelQueue.remove();
                res.get(level).add(now.val);
                if(now.left!=null){
                    levelQueue.add(now.left);
                }
                if(now.right!=null){
                    levelQueue.add(now.right);
                }
            }
            level ++;
        }
        return res;
    }

    /**
     * 中序遍历1
     */
    private class MockMethod {
        String name;
        TreeNode node;

        public MockMethod(String name, TreeNode node) {
            this.name = name;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<MockMethod> stack = new Stack<MockMethod>() {};
        stack.push(new MockMethod("do",root));
        while (!stack.isEmpty()) {
            MockMethod mockMethod = stack.pop();
            if (mockMethod.name.equals("print")) {
                list.add(mockMethod.node.val);
            } else {
                if (mockMethod.node.right != null) {
                    stack.push(new MockMethod("go",mockMethod.node.right));
                }
                stack.push(new MockMethod("print", mockMethod.node));
                if (mockMethod.node.left != null) {
                    stack.push(new MockMethod("go",mockMethod.node.left));
                }
            }
        }
        return list;
    }
    /**
     * 中序遍历2
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        helper(root,list);
        return list;
    }
    public void helper(TreeNode root, List<Integer> list){
        if(root == null){
            return ;
        }
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }

}
