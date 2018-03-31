package traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution of the 1st task.
 *
 * Created by Lakhno Anton
 * at 20:02 28.03.2018.
 *
 * @author Lakhno Anton
 * @version 1.0.0
 * @since 1.0.0
 */
public class Solution {

	/**
	 * #144. Binary Tree Preorder Traversal.
	 * @param root Root element.
	 * @return List of traversed tree elements.
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;

		result.add(root.val);
		if (root.left != null) result.addAll(preorderTraversal(root.left));
		if (root.right != null) result.addAll(preorderTraversal(root.right));

		return result;
	}

	/**
	 * #94. Binary Tree Inorder Traversal.
	 * @param root Root element.
	 * @return List of traversed tree elements.
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;

		if (root.left != null) result.addAll(inorderTraversal(root.left));
		result.add(root.val);
		if (root.right != null) result.addAll(inorderTraversal(root.right));

		return result;
	}

	/**
	 * #145. Binary Tree Postorder Traversal
	 * @param root Root element.
	 * @return List of traversed tree elements.
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;

		if (root.left != null) result.addAll(postorderTraversal(root.left));
		if (root.right != null) result.addAll(postorderTraversal(root.right));
		result.add(root.val);

		return result;
	}

	/**
	 * #102. Binary Tree Level Order Traversal
	 * @param root Root element.
	 * @return List of traversed tree elements.
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		// First level
		List<Integer> level1 = new ArrayList<>();
		level1.add(root.val);
		result.add(level1);

		// Other levels
		// Prepare next level
		// Create linked list with children of the root
		LinkedList<TreeNode> nextLevel = new LinkedList<>();
		nextLevel.add(root.left);
		nextLevel.add(root.right);
		// Do operations with them
		while (!nextLevel.isEmpty()) {
			List<Integer> level = levelTraverse(nextLevel);
			if (!level.isEmpty()) {
				result.add(level);
				// Replace next level value by another new level
				nextLevel = getNextLevel(nextLevel);
			} else {
				break;
			}
		}

		return result;
	}

	public List<Integer> levelTraverse(LinkedList<TreeNode> nodes) {
		List<Integer> thisLevel = new ArrayList<>();
		nodes.forEach(node -> {if (node != null) thisLevel.add(node.val);});
		return thisLevel;
	}

	public LinkedList<TreeNode> getNextLevel(LinkedList<TreeNode> nodes) {
		LinkedList<TreeNode> nextLevel = new LinkedList<>();
		nodes.forEach(node -> {
			if (node != null) {
				if (node.left != null) nextLevel.add(node.left);
				if (node.right != null) nextLevel.add(node.right);
			}
		});
		return nextLevel;
	}

	/**
	 * #104. Maximum Depth of Binary Tree.
	 *
	 * Solved.
	 * @param root Root mode.
	 * @return Depth of the tree.
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int level = 1;
		return Math.max(
				level + maxDepth(root.left),
				level + maxDepth(root.right)
		);
	}

	/**
	 * Symmetric Tree
	 * @param root Root node.
	 * @return Tells us is tree symmetric.
	 */
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root);
	}

	/**
	 * Inner method for symmetric checking tree.
	 * @param left Left element.
	 * @param right Right element.
	 * @return Is tree symmetric.
	 */
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == null && right == null;
		}

		return (left.val == right.val)
				&& isSymmetric(left.left, right.right)
				&& isSymmetric(left.right, right.left);
	}

}
