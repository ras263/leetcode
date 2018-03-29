/**
 * Created by Lakhno Anton
 * at 19:53 29.03.2018.
 *
 * @author Lakhno Anton
 * @version 1.1.1
 * @since 1.1.1
 */
public class Solution {

	/**
	 * 2. Add Two Numbers
	 *
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//if (l1 == null && l2 == null) return new ListNode(0);

		int firstNodeValue = l1.val + l2.val;
		ListNode result = new ListNode(firstNodeValue % 10);
		int inc = firstNodeValue / 10;

		addTwoNumbersInner(l1.next, l2.next, inc, result);

		return result;
	}

	public ListNode addTwoNumbersInner(ListNode l1, ListNode l2, int inc, ListNode result) {
		int preresult = l1.val + l2.val + inc;
		result.next = new ListNode(preresult % 10);
		inc = preresult / 10;
		if (l1.next != null || l2.next != null || inc == 1) {
			addTwoNumbersInner(
					(l1.next != null) ? l1.next : new ListNode(0),
					(l2.next != null) ? l2.next : new ListNode(0),
					inc,
					result.next
			);
		}
		return result;
	}

}
