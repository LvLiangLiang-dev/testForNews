package com.lll.algorithm.tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 牛客网上的关于树的习题，有很多剑指offer的题目。
 * 嘿嘿~
 * Created by lvliangliang on 2018/01/02.
 */
public class tree_nowcoder {
    @Test
    public void test_(){
        //BST 5 6 7 8 9 10 11
        TreeNode root = new TreeNode(8);
        TreeNode _2ll = new TreeNode(6);
        TreeNode _2lr = new TreeNode(10);
        TreeNode _3l1 = new TreeNode(5);
        TreeNode _3l2 = new TreeNode(7);
        TreeNode _3l3 = new TreeNode(9);
        TreeNode _3l4 = new TreeNode(11);
        root.left = _2ll;
        root.right = _2lr;
        _2ll.left = _3l1;
        _2ll.right = _3l2;
        _2lr.left = _3l3;
        _2lr.right = _3l4;
//        ArrayList<ArrayList<Integer>> temp = FindPath(root, 27);
//        System.out.println(Arrays.toString(new ArrayList[]{temp}));
        int temp=TreeDepth(root);
        System.out.println(temp);

    }
    /**
     *  给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     *  注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */


    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     *      巧妙的分析镜像的特点，通过递归一层一层的比较
     *      因为二叉树只有俩个枝叶，所以能通过这种比较来求得答案，仔细想想，也只有这俩个比较
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)return true;
        return helps(pRoot.left,pRoot.right);
    }
    public boolean helps(TreeNode left,TreeNode right){
        if(left==null)return right==null;
        if(right==null)return false;
        if(left.val==right.val)
            return helps(left.left,right.right)&& helps(left.right,right.left);
        else
            return false;
    }
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *      一直有问题，吗的
     *
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)return null;
        TreeNode temp=null;
        help(pRootOfTree,temp);
        TreeNode temps=pRootOfTree;
        if(temps.left==null)
            temps=temps.left;
        return temps;
    }
    public void help(TreeNode root,TreeNode aux){
        if(root==null)return;
        help(root.left,aux);
        root.left=aux;
        if(aux!=null)aux.right=root;
        aux=root;
        help(root.right,aux);
    }
    /**
     *  求二叉树深度
     *      自己写的虽然通过了，但是自己也不明白return是怎么通过的
     *
     *      第二个是标准答案，更加清晰，思考的时候很顺滑。。。
     */
    public int TreeDepth2(TreeNode root) {
        if(root==null)return 0;
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return Math.max(left,right)+1;
    }

    int length=0;
    int max=0;
    public int TreeDepth(TreeNode root) {
        if(root==null)return max;
        length++;
        if(root.left!=null)  TreeDepth(root.left);
        if(root.right!=null) TreeDepth(root.right);
        if(length>max)max=length;
        length--;
        return max;
    }

    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *
     * 通过DFS，注意返回前的记录数组减一，就是回溯。
     *
     */
    public ArrayList<ArrayList<Integer>> listall = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listall;
        list.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null)
            listall.add(new ArrayList(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listall;
    }
        /**
         * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
         * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
         *
         * 通过递归写的，树和递归真是一对好基友~~
         *      自己写的，注意边界条件，以及前后处理，，很容易出错。
         */

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0 || sequence == null) return false;
        return todo(sequence, 0, sequence.length - 1);
    }

    public boolean todo(int[] arr, int start, int end) {
        if (start >= end) return true;

        int root = arr[end];
        int mid = -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] >= root) {
                mid = i;
                break;
            }
        }
        for (int i = mid; i <= end; i++) {
            if (arr[i] < root)
                return false;
        }
        return todo(arr, start, mid - 1) && todo(arr, mid, end - 1);
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * <p>
     * 这一题主要是细节的考虑
     * 没有通过，好多细节考虑不清楚
     * <p>
     * **如果是返回布尔值的话，注意返回的处理
     * 每个条件都要有返回值，而且递归中注意返回的值是什么，和结果有什么关系。
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return doa(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean doa(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root2.val == root1.val) {
            return doa(root1.left, root2.left) && doa(root1.right, root2.right);
        } else
            return false;
    }

    /**
     * 求二叉树的镜像
     * 我是通过递归来写的，就是交换左右子树就可以
     * 然后可以用层次遍历类似的思想来做，就是通过栈来操作，不过层次遍历直接输出，
     * 镜像还要交换下。
     * 很好很不错~~hhha
     */
    public void Mirror(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null || node.right != null) {
                TreeNode nodeLeft = node.left;
                TreeNode nodeRight = node.right;
                node.left = nodeRight;
                node.right = nodeLeft;
            }
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = new TreeNode(0);
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

}

    /**
     * 牛客-重建二叉树-已知前序后中序
     * ？条件，如果只有一边，返回另一边怎么办
     * 等下好像是递归最后能到最后一个
     * X       等输出写好了在回来debug一下
     */
    private static void do_dota() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 6, 8};
        TreeNode treeNode = dota(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode dota(int[] pre, int startpre, int endpre, int[] in, int startin, int endin) {
        if (startpre > endpre || startin > endin) return null;
        TreeNode root = new TreeNode(pre[startpre]);
        for (int i = startin; i <= endin; i++) {
            if (in[i] == pre[startpre]) {
                int l = i - startin;
                root.left = dota(pre, startpre + 1, startpre + l, in, startin, startin + l);
                root.right = dota(pre, startpre + 1 + l, endpre, in, l + startin + 1, endin);
                break;
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}