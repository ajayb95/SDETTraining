package sdet.week12.assessment;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Q2_Ajay {

	@Test
	public void example1() {
		int[] inp = { 4, 5, 2, 1, 5, 4, 2, 1, 0, 1 };
		System.out.println(findDuplicates(inp));
	}

	@Test
	public void example2() {
		int[] inp = { 1, 2, 3, 4, 2, 3, 4 };
		System.out.println(findDuplicates(inp));
	}
	
	@Test
	public void example3() {
		int[] inp = { 1, 2, 3, 4 };
		System.out.println(findDuplicates(inp));
	}
	
	@Test
	public void example4() {
		int[] inp = { 1 };
		System.out.println(findDuplicates(inp));
	}

	// Pseudo code
	// Space complexity: O[N]
	// Time complexity: O[N]
	/*
	 * Add occurance of each element in a hash map find the max value of the
	 * occurance if max value of the occurance is 1 then return no frequent element
	 * in the array else, collect the elements with max occurance as a list using
	 * stream
	 */

	private String findDuplicates(int[] inp) {
		Map<Integer, Integer> map = new HashMap<>();

		if (inp.length < 2)
			throw new RuntimeException("There is no frequent element in the array");

		for (int i : inp)
			map.put(i, map.getOrDefault(i, 0) + 1);

		int max = Collections.max(map.values());

		if (max < 2)
			throw new RuntimeException("There is no frequent element in the array");

		List<Integer> op = map.entrySet().stream().filter(m -> m.getValue() == max).flatMap(s -> Stream.of(s.getKey()))
				.collect(Collectors.toList());

		return op + " repeated " + max + " times";
	}
}