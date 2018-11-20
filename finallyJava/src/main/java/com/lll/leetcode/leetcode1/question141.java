/**
 * 
 */
package com.lll.leetcode.leetcode1;

import java.util.HashSet;
import java.util.Set;

/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年7月18日 上午9:15:00
* class illustration:
*/
/**
 * @author NewUser
 *
 */
class ListNode_b{
	int val;
	ListNode_b next;
	ListNode_b(int x){
		val=x;
		next=null;
	}
}
public class question141 {
	public static void main(String[] args) {
		test();
	}
	//这个很好很强大，双指针算法
	//要用很多，这个只是其中之一，下次遇上再说。
	public boolean hasCycle(ListNode_b head) {
		if(head==null||head.next==null)return false;
        ListNode_b slow=head;
        ListNode_b fast=head.next;
        while(slow!=fast){
            if(fast==null||fast.next==null)return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
	}
	//用了hashset这个collection。
	//可是有个问题，hashset是不能存储重复的，在这里面不能重复的是什么，是val还是next？还是俩者都一样才算是重复？
	public boolean hasCycle2(ListNode_b head) {
		 Set<ListNode_b> temp=new HashSet<ListNode_b>();
		 while(head!=null){
			 if(temp.contains(head)){
				 return true;
			 }else{
				 temp.add(head);
				 head=head.next;
			 }
		 }
		 return false;
	}
	public static void test(){
		Set<ListNode_b> temp2=new HashSet<ListNode_b>();
		ListNode_b a=new ListNode_b(1);
		ListNode_b b=new ListNode_b(2);
		a.next=b;
		ListNode_b c=new ListNode_b(1);
		c.next=null;
		temp2.add(a);
		temp2.add(c);
		temp2.add(a);
		temp2.add(a);
		temp2.add(b);
		System.out.println(temp2.toString());
		System.out.println(a.hashCode());
	}
}
