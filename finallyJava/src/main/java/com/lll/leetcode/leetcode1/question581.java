package com.lll.leetcode.leetcode1;

import java.util.Arrays;

public class question581 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={2, 6, 4, 8, 10, 9, 15};
		int []before=nums.clone();
		Arrays.sort(nums);
		int qian=0,hou=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=before[i]){
				qian=i;
				break;
			}
		}
		for(int i=nums.length-1;i>=0;i--){
			if(nums[i]!=before[i]){
				hou=i;
				break;
			}
		}
//		return hou-qian+1;

	}

}
