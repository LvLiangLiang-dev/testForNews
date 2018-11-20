/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年7月4日 下午3:46:51
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question9 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(12321));
	}
	public static boolean isPalindrome(int x) {
        String s=Integer.toString(x);
        StringBuffer sb=new StringBuffer(s);
        String sbs=sb.reverse().toString();
        return sbs.equals(s);
    }
}


