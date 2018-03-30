import java.util.HashMap;
import java.util.Map;

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
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int inc) {
		ListNode res = null;
		int preresult = l1.val + l2.val + inc;
		res = new ListNode(preresult % 10);
		inc = preresult / 10;
		if (l1.next != null || l2.next != null || inc == 1) {
			res.next = addTwoNumbers(
				(l1.next != null) ? l1.next : new ListNode(0),
				(l2.next != null) ? l2.next : new ListNode(0),
				inc
			);
		}
		return res;
	}

	/**
	 * 3. Longest Substring Without Repeating Characters
	 * Correct, but non efficient solution.
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null) return 0;
		int max = (!s.isEmpty()) ? 1 : 0;
		for (int i = 0; i < s.length(); i++) {
			String from = s.substring(i, i+1);
			String other = s.substring(i + 1);
			String substring = from;
			for (int j = 0; j < other.length(); j++) {
				String next = other.substring(j, j+1);
				if (!substring.contains(next)) {
					substring += next;
					if (substring.length() > max) {
						max = substring.length();
					}
				} else {
					break;
				}
			}
		}
		return max;
	}

	/**
	 * 3. Longest Substring Without Repeating Characters
	 * Version 2
	 * Solved with manual after being stuck with solution.
	 * <a href="https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/">
	 *     Manual is here.</a>
	 */
	public int lengthOfLongestSubstringV2(String s) {
		if (s == null) return 0;
		int max = (!s.isEmpty()) ? 1 : 0;
		int length = 0;
		Map<Character, Integer> indices = new HashMap<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (indices.containsKey(chars[i])) {
				Integer prevIndex = indices.get(chars[i]);
				if (i - length > prevIndex) {
					length++;
				} else {
					length = i - prevIndex;
				}
			} else {
				length++;
			}
			if (length > max) {
				max = length;
			}
			indices.put(chars[i], i);
		}
		return max;
	}

}
