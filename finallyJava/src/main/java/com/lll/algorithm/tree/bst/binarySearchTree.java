package com.lll.algorithm.tree.bst;
import java.util.LinkedList;
/**
 * insert:
 *      在BST中插入节点
 *          通过递归插入节点，如果大于node的值，就到右节点再去比较，反之，则回到左节点比较
 *          直到找到一样的覆盖，或者是找到叶子节点添加新的~~
 *          这是递归实现
 *
 *          非递归实现：
 *              ？
 * contain:
 *      是否包含某个key
 *      通过递归实现，树和递归真是好搭档啊 哈哈
 *
 * search:
 *      通过key找value
 *
 *      这里面使用的数值模式都是键值对，如果只有key，效果是一样的。
 *
 * preOrder/inOrder/postOrder
 *
 * levelOrder:
 *      层次遍历，广度优先
 *      通过队列，先进先出实现
 *          每次输出一个时，就把他的左右子树全部加到队列中去，这样一层的都在队列中，输出时也是在下一层之前的
 *          所以就实现了每次输出一层的目的。
 *          （可以想一下，所谓的归并，快速排序，都是类似二叉树深度优先的实现的变化之一）
 *
 * Created by Fayne on 2017/12/20.
 */
public class binarySearchTree<Key extends Comparable<Key>,Value> {
    public static void main(String[] args) {
        binarySearchTree binarySearchTree=new binarySearchTree();
        binarySearchTree.insert(1,2);
        binarySearchTree.insert(2,2);
        binarySearchTree.insert(33,2);
        System.out.println(binarySearchTree.size());
        System.out.println(binarySearchTree.contain(4));
        System.out.println(binarySearchTree.search(33));
        binarySearchTree.levelOrder();
    }
    // 树中的节点为私有的类, 外界不需要了解二分搜索树节点的具体实现
    private class Node{
        private Node left;

        private Node right;
        private Key key;

        private Value value;
        public Node(Key key, Value value) {
            left=null;
            right=null;
            this.key = key;
            this.value = value;
        }
    }
    private Node root;
    private int count;
    //BST的构造函数，直接初始化 root根节点为空，count为0；
    public binarySearchTree() {
        root=null;
        count=0;
    }
    public int size(){return count;}
    public boolean isEmpty(){return count==0;}
    //插入（key,value)节点
    public void insert(Key key,Value value){
        root=insert(root,key,value);
    }
    public boolean contain(Key key){ return contain(root,key);}
    public Value search(Key key){return search(root,key);}
    public void preOrder(){preOrder(root);}
    public void inOrder(){inOrder(root);}
    public void postOrder(){postOrder(root);}
    public void levelOrder(){
        LinkedList<Node>linkedList=new LinkedList<>();
        linkedList.add(root);
        while(!linkedList.isEmpty()){
            Node temp=linkedList.remove();
            System.out.println(temp.key);
            if(temp.left!=null){
                linkedList.add(temp.left);
            }
            if(temp.right!=null){
                linkedList.add(temp.right);
            }
        }
    }

    private void preOrder(Node node){
        if(node!=null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    private void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }
    private void postOrder(Node node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }
    private Value search(Node node,Key key){
        if(node==null)return null;
        if(node.key.compareTo(key)==0)return node.value;
        else if(node.key.compareTo(key)>0){
            return search(node.left,key);
        }else {
            return search(node.right,key);
        }
    }

    private boolean contain(Node node,Key key){
        if(node==null)return false;
        if(node.key.compareTo(key)==0)return true;
        else if(node.key.compareTo(key)>0){
            return contain(node.left,key);
        }else{
            return contain(node.right,key);
        }
    }
    //插入（key,value)节点,node为根节点，返回的也是根节点
    private Node insert(Node node,Key key,Value value){
        if(node==null){
            count++;
            return new Node(key,value);
        }
        if(node.key.compareTo(key)==0){
            node.value=value;
        }else if(node.key.compareTo(key)<0){
            node.right=insert(node.right,key,value);
        }else{
            node.left=insert(node.left,key,value);
        }
        return node;
    }
}
