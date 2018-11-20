/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年7月25日 下午2:35:47
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question66 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int []ll={4,1};
		System.out.print(ll[1]);
		int []l=null;
		l=plusOne(ll);
		System.out.print(l[1]);
		System.out.print(l[0]);
	}
    public static int[] plusOne(int[] digits) {
        int length=digits.length;
        int result=0;
        for(int i=0;i<length;i++){  
            result=(int) (digits[i]*(Math.pow(10, i))+result);
        }
        result=result+1;
        int []back=new int[2];
        int j=0;
        while(result>0){ 
            back[j]=result%10;
            result=result/10;
            j++;
        }
        
        return back;
    } 
}
