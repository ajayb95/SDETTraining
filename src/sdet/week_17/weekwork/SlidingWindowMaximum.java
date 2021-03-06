package sdet.week_17.weekwork;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]
*/

public class SlidingWindowMaximum {
	@Test
	public void example1() {
		int[] nums= {1,3,-1,-3,5,3,6,7};
		int k=3;
		windowMax(nums, k);
	}
	
	private void windowMax(int[] nums,int k) {
		Set<Integer> set=new TreeSet<Integer>();
		int[] output=new int[nums.length-k+1];
		int start=0,end=0,ind=0;
		while(end<nums.length) {
			set.add(nums[end++]);
			if(end>=k) {
				if(end>k)
					set.remove(Integer.valueOf(nums[start++]));
				Object[] array = set.toArray();
				output[ind++]=(int)array[array.length-1];
			}
		}
		System.out.println(Arrays.toString(output));
	}
}
