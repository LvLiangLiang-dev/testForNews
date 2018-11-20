package com.lll.leetcode.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class question448 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		int len=nums.length;
		List<Integer> result=new ArrayList<Integer>();
		for(int i=1;i<len;i++){
			int count=0;
			for(int j=0;j<len;j++)
				if(nums[j]==i)count++;
			if(count==0)result.add(i);
		}
		return result;
	}
	public static List<Integer> findDisappearedNumbers2(int[] nums) {
		List<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			int temp=Math.abs(nums[i])-1;
			if(nums[temp]>0)nums[temp]=-nums[temp];
		}
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0)result.add(i+1);
		}
		return result;
	}
}
