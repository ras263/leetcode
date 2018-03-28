package traverse;

import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.Arrays;
import java.util.List;

/**
 * Test class for first solution.
 *
 * Created by Lakhno Anton on 28.03.2018.
 */
public class SolutionTest {

	TreeNode root;
	Solution solution;

	@Before
	public void setUp() throws Exception {
		TreeNode root = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		root.right = second;
		second.left = third;

		this.root = root;

		solution = new Solution();
	}

	@Test
	public void preorderTraversal() throws Exception {
		List<Integer> actual = solution.preorderTraversal(this.root);
		ReflectionAssert.assertLenientEquals(Arrays.asList(1, 2, 3), actual);
		System.out.println(String.format("Actual value is: %s", actual.toString()));
	}



}
