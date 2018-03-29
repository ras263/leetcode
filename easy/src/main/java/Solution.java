import java.util.Arrays;

/**
 * Created by Lakhno Anton
 * at 13:49 29.03.2018.
 *kadentzeva anastasiya
 * @author Lakhno Anton
 * @version 1.1.0
 * @since 1.1.0
 */
public class Solution {

	/**
	 * # 1 Two sum problem.
	 * Solved. 2018.03.29 16:28
	 */
	public int[] twoSum(int[] nums, int target) {
		int startIndex = 0;
		int endIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			int first = nums[i];
			int[] other = Arrays.copyOfRange(nums, i + 1, nums.length);
			for (int j = 0; j < other.length; j++) {
				endIndex = j + startIndex + 1;
				if (first + other[j] == target) return new int[]{startIndex, endIndex};
			}
			startIndex++;
		}
		return new int[]{};
	}

}
