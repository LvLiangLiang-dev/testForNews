/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年7月7日 上午9:38:59
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question14 {
	 @SuppressWarnings("unused")
	public static void main(String [] args){
		 String []ff={"1ac4dsfs","1ac4d","1ac4dbc"};
		 String []ff1={};
		 
		 System.out.println(longestCommonPrefix(ff1));
	 }
	 public static String longestCommonPrefix(String[] strs) {
	        
		 if(strs==null||strs.length==0){
	            return "";
	     }else{
            int l_length=strs.length;
			int length_max=strs[0].length();
			
			char []longest=new char[length_max+1];
			int temp=0;
			s:for(temp=0;temp<length_max;temp++){
				longest[temp]=strs[0].toCharArray()[temp];
				for(int j=1;j<l_length;j++){
					if(strs[j].length()<temp+1){
						break s;
					}else{
						if(longest[temp]!=strs[j].toCharArray()[temp]){
							break s;
						}
					}
				}
			}
			
			if(temp==0){
				 return "";
			}else{
				String result=new String(longest,0,temp);
				return result;
			}
	    }
	}
}
//有几个问题
//在定义记录最长前缀的字符数组时，怎么确定他的长度，如果要给一个固定的长度，我给的是第一个，如果不给固定的长度，可以使用别的方法吗？
//感觉写的比较复杂，怎么才能简单的设定这种比较规则，我是以第一个字符串的每个字符作为最长前缀的字符去比较的，如果不这么做，可以怎么做？
//返回的时候是重新写的，感觉可以更加精炼一些。并且在判断是null和没有最长前缀俩种可能时可能做了多余的工作。