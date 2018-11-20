/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年7月13日 上午11:01:42
* class illustration:
*/
/**
 * @author NewUser
 *
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){val=x;}
}
public class question21 {
	public static void main(String []args){
		ListNode a=new ListNode(1);
		a.next=new ListNode(3);
		a.next.next=new ListNode(4);
		a.next.next.next=new ListNode(7);
		
		ListNode b=new ListNode(2);
		b.next=new ListNode(4);
		b.next.next=new ListNode(5);
		b.next.next.next=new ListNode(8);
		
		ListNode result=mergeTwoLists(a,b);
		for(int i=0;i<8;i++){
			System.out.println(result.val);
			result=result.next;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {  
	    ListNode helper = new ListNode(0);  
	    ListNode pre = helper;  
	    helper.next = l1;  
	    while(l1!=null && l2 != null)  
	    {  
	        if(l1.val>l2.val)  
	        {  
	            ListNode next = l2.next;  
	            l2.next = pre.next;  
	            pre.next = l2;  
	            l2 = next;  
	        }  
	        else  
	        {  
	            l1 = l1.next;  
	        }  
	        pre = pre.next;  
	  
	    }  
	    if(l2!=null)  
	    {  
	        pre.next = l2;  
	    }  
	    return helper.next;  
	}  

}