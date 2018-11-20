/**
 * 
 */
package com.lll.leetcode.leetcode1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* @author lvliangliang E-mail:lvliangbupt@136.com
* @version Create time：2017年9月14日 上午9:53:01
* class illustration:
*/
/**
 * @author NewUser
 *
 */
public class question532 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,3,4,1};
		int b=findPairs3(a,1);
		System.out.println(b);

	}
	public static  int findPairs(int[] nums, int k) {
        int count=0;
        Arrays.sort(nums);
        for(int j=0;j<nums.length;j++){
            for(int i=j+1;i<nums.length;i++){
                 
                 while(j<nums.length-1&&nums[j]==nums[j+1])
                     j++;
                 
                 if(nums[i]-nums[j]==k){
                     count++;
                     break;
                 }
            }  
        }
        return count;
    }
	public static int findPairs2(int []nums,int k){
		if(k<0||nums.length<2)return 0;
		int left=0,right=1,count=0;
		Arrays.sort(nums);
		while(right<nums.length){
			int leftnum=nums[left];
			int rightnum=nums[right];
			if(rightnum-leftnum>k)left++;
			else if(rightnum-leftnum<k)right++;
			else{
				count++;
				while(left<nums.length&&leftnum==nums[left])left++;
				while(right<nums.length&&rightnum==nums[right])right++;
			}
			if(left==right)right++;
		}
		return count;
	}
	public static int findPairs3(int []nums,int k){
		int count=0;
		Map<Integer,Integer>map=new HashMap<Integer,Integer>();
		for(int m:nums){
			map.put(m, map.getOrDefault(m, 0)+1);
		}
		for(Map.Entry<Integer, Integer>temp:map.entrySet()){
			if(k==0){if(temp.getValue()>=2)count++;}
			else{if(map.containsKey(temp.getKey()+k))count++;}
		}
		return count;
	}

}
