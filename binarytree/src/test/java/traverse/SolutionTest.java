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
	TreeNode complexRoot;
	TreeNode symRoot;
	Solution solution;

	@Before
	public void setUp() throws Exception {
		TreeNode root = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		root.right = second;
		second.left = third;

		this.root = root;

		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);

		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;

		this.complexRoot = node3;

		TreeNode node1 = new TreeNode(1);
		TreeNode node2l = new TreeNode(2);
		TreeNode node2r = new TreeNode(2);
		TreeNode node3l = new TreeNode(3);
		TreeNode node3r = new TreeNode(3);
		TreeNode node4l = new TreeNode(4);
		TreeNode node4r = new TreeNode(4);

		node1.left = node2l;
		node1.right = node2r;
		node2l.left = node3l;
		node2l.right = node4l;
		node2r.left = node4r;
		node2r.right = node3r;

		this.symRoot = node1;

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

	@Test
	public void levelOrder() throws Exception {
		List<List<Integer>> expected = Arrays.asList(
				Arrays.asList(3),
				Arrays.asList(9, 20),
				Arrays.asList(15, 7)
		);
		ReflectionAssert.assertReflectionEquals(expected, solution.levelOrder(complexRoot));
	}

	@Test
	public void levelOrderSmall() throws Exception {
		List<List<Integer>> expected = Arrays.asList(
				Arrays.asList(1)
		);
		TreeNode simpleRoot = new TreeNode(1);
		ReflectionAssert.assertReflectionEquals(expected, solution.levelOrder(simpleRoot));
	}

	@Test
	public void maxDepth() throws Exception {
		Assert.assertTrue(solution.maxDepth(complexRoot) == 3);
	}

	@Test
	public void testIsSymmetric() throws Exception {
		Assert.assertFalse(solution.isSymmetric(complexRoot));
		Assert.assertTrue(solution.isSymmetric(symRoot));
	}


}
