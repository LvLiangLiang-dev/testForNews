/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年9月12日 下午4:30:58
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question189 {
	public static void main(String []args){
		int a[]={1,2,3,4,5,6,7};
		//int b[]=rotate(a,4);
		//for(int j=0;j<b.length;j++) System.out.print(b[j]+" ");
	}
	public static void rotate(int[] nums, int k) {
		int len=nums.length;
        if(k>len)k=k%len;
		int a[]=new int[len];
		for(int i=0;i<len;i++){
			if(i-k>=0)a[i]=nums[i-k];
			else a[i]=nums[len-k+i];
		}
		for(int i=0;i<len;i++){
            nums[i]=a[i];
        }
    }

}
