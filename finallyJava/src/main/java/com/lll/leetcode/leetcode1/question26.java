/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年9月13日 下午2:34:23
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int removeDuplicates(int[] nums) {
	 if(nums.length==0)return 0;
	    if(nums.length==1)return 1;
	    int count=0;
	    for(int i=1;i<nums.length;i++){
	        if(nums[count]!=nums[i]){
	            count++;
	            nums[count]=nums[i];
	        }
	    }
	    return count+1;
	}
}
