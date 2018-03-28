package traverse;

import java.util.ArrayList;
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

		if (root.left != null) result.addAll(postorderTraversal(root.left));
		if (root.right != null) result.addAll(postorderTraversal(root.right));
		result.add(root.val);

		return result;
	}

}
