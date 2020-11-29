package sdet.week11.assessment;
/*
3) Given an input array and two unique numbers, find the smallest distance between those 2 numbers
   Example:a
   
   Input1: [5,6,8,9,1,4,1] Input2: 8,1 Output: 2
      a) If there are no occurances of the unique numbers, then throw exception
      b) If there are multiple matches, the least distance should be considered
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Q3_Ajay {
//Brute force Space complexity: O[N] time complexity: O[N*M]
	/*
	 * iterate through each element in the array with window starting and ending
	 * with values in input2 find the distance between and compare it with the
	 * existing min distance finally return the min distance
	 */
	@Test
	public void example1() {
		int[] arr = { 5, 6, 8, 9, 1, 4, 1 };
		int[] inp = { 8, 1 };
		System.out.println(findMindistance(arr, inp));
	}

	private int findMindistance(int[] arr, int[] inp) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < inp.length; i++)
			list.add(inp[i]);
		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (list.contains(arr[i])) {
				int end = list.get(list.indexOf(arr[i]) == 0 ? 1 : 0);
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] == end)
						minDist = Math.min(minDist, j - i);
				}
			}
		}

		if (minDist < 0)
			throw new RuntimeException("No min distance found");

		return minDist;
	}

}
