/**
 * 
 */
package com.lll.leetcode.leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年9月17日 上午9:22:42
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question118 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>>re=generate(5);

	}
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>>result=new ArrayList<List<Integer>>();
		List<Integer> row=new ArrayList<Integer>();
		
		
		for(int i=0;i<numRows;i++){
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++){
				row.set(j, row.get(j+1)+row.get(j));
			}
			result.add(row);
		}
		
		for(int i=0;i<numRows;i++){
			System.out.println(result.get(i).toString());
		}
		return result;
	        
	}
}
