/**
 * 
 */
package com.lll.leetcode.leetcode1;
/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年9月13日 上午10:12:51
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question605 {
	public static void main(String []args){
		int a[]={1};
		boolean b=canPlaceFlowers(a,1);
		System.out.println(b);
		
	}
	public static boolean canPlaceFlowers(int[] flowerbed,int n){
		int len=flowerbed.length;
        if(n==0)return true;
		if(len==1&&n<=1&&flowerbed[0]==0)return true;	
		for(int i=0;i<len;i++){
			if(i+1<len&&flowerbed[i]==0&&flowerbed[i+1]==0&&i==0){
				flowerbed[i]=1;
				n--;
			}
			if(i+2<len&&flowerbed[i]==0&&flowerbed[i+1]==0&&flowerbed[i+2]==0){
				flowerbed[i+1]=1;
				n--;
			}
			if(i+1<len&&flowerbed[i]==0&&flowerbed[i+1]==0&&i==len-2){
				flowerbed[i+1]=1;
				n--;
			}
			if(n==0)break;
		}
        return n == 0;
	}

}
