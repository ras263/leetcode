import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import static org.junit.Assert.*;

/**
 * Solutions of easy problems test.
 * Created by Anton Lakhno on 29.03.2018.
 */
public class SolutionTest {

	Solution solution;

	@Before
	public void setUp() throws Exception {
		solution = new Solution();
	}

	@Test
	public void twoSum() throws Exception {
		int[] nums = new int[]{2, 7, 11, 15};

		ReflectionAssert.assertReflectionEquals(new int[]{0, 1}, solution.twoSum(nums, 9));
		ReflectionAssert.assertReflectionEquals(new int[]{0, 2}, solution.twoSum(nums, 13));
		ReflectionAssert.assertReflectionEquals(new int[]{1, 2}, solution.twoSum(nums, 18));
	}



}
