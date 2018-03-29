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
	 * Binary Tree Preorder Traversal.
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
	 * Binary Tree Inorder Traversal.
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
	 * Binary Tree Postorder Traversal
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
	 * Binary Tree Level Order Traversal
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
			result.add(levelTraverse(nextLevel));
			// Replace next level value by another new level
			nextLevel = getNextLevel(nextLevel);
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

}
