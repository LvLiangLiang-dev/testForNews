/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年9月7日 下午3:05:30
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question121 {
	public static void main(String []args){
		int a[]={1,2,3,100,32,2,78,21,0};
		int result=maxProfit(a);
		System.out.println(result);
	}
	public static int maxProfit(int[] prices){
		int length=prices.length;
		if(length<2)return 0;
		else{
			int temp=prices[length-1]-prices[length-2];
			if(temp<0)	temp=0;
			for(int i=length-1;i>=0;i--){
				for(int j=i-1;j>=0;j--){
					if(temp>prices[i]-prices[j]);
					else temp=prices[i]-prices[j];
				}
			}
			return temp;
		}
	}
}
//如果是嵌套循环，则在数组超大的时候gg，时间超时。
//如果不嵌套，吗的真的想不来。。。。


