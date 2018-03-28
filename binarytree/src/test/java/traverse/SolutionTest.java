package traverse;

import org.junit.Assert;
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
		ReflectionAssert.assertReflectionEquals(Arrays.asList(1, 2, 3), actual);
		System.out.println(String.format("Actual value is: %s", actual.toString()));
	}

	@Test
	public void inorderTraversal() throws Exception {
		List<Integer> actual = solution.inorderTraversal(this.root);
		ReflectionAssert.assertReflectionEquals(Arrays.asList(1, 3, 2), actual);
		System.out.println(String.format("Actual value is: %s", actual.toString()));
	}

	@Test
	public void postorderTraversal() throws Exception {
		List<Integer> actual = solution.postorderTraversal(this.root);
		ReflectionAssert.assertReflectionEquals(Arrays.asList(3, 2, 1), actual);
		System.out.println(String.format("Actual value is: %s", actual.toString()));
	}

	@Test
	public void emptyListOnNullRoot() throws Exception {
		Assert.assertTrue(solution.preorderTraversal(null).isEmpty());
		Assert.assertTrue(solution.inorderTraversal(null).isEmpty());
		Assert.assertTrue(solution.postorderTraversal(null).isEmpty());
	}


}
