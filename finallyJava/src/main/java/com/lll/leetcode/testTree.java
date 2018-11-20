/**
 * 
 */
package com.lll.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年10月23日 上午9:10:36
* class illustration:
*/
/**
 * @author NewUser
 *
 */
class 	TreeNode{
	int val=0;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}
public class testTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	}

	/**
	 * 
	 */
	private static void question637() {
		//定义tree
		TreeNode root=null,l1 = null,r1 = null,r1l2 = null,r1r2 = null;
		root.val=3;
		root.left=l1;
		root.right=r1;
		l1.val=9;
		r1.val=20;
		r1.left=r1l2;
		r1.right=r1r2;
		r1l2.val=15;
		r1r2.val=7;
		
		//
		Queue<TreeNode>queue=new LinkedList<TreeNode>();
		List<Double>list=new ArrayList<Double>();
		
		queue.add(root);
		while(!queue.isEmpty()){
			int n=queue.size();
			double sum=0;
			for(int i=0;i<n;i++){
				TreeNode temp=queue.poll();
				sum+=temp.val;
				if(temp.left!=null)queue.offer(temp.left);
				if(temp.right!=null)queue.offer(temp.right);
			}
			list.add(sum);
		}
		System.out.println(list.get(0));
	}

}
