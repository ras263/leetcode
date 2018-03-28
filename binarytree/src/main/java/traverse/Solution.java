package traverse;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution of the 1st task.
 * Binary Tree Preorder Traversal.
 *
 * Created by Lakhno Anton
 * at 20:02 28.03.2018.
 *
 * @author Lakhno Anton
 * @version 1.0.0
 * @since 1.0.0
 */
public class Solution {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		result.add(root.val);
		if (root.left != null) result.addAll(preorderTraversal(root.left));
		if (root.right != null) result.addAll(preorderTraversal(root.right));

		return result;
	}

}
