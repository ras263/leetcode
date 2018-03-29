import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import static org.junit.Assert.*;

/**
 * Test class for medium problem solutions.
 *
 * Created by Lakhno Anton on 29.03.2018.
 */
public class SolutionTest {

	Solution solution;

	@Before
	public void setUp() throws Exception {
		solution = new Solution();
	}

	/**
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 * @throws Exception
	 */
	@Test
	public void addTwoNumbers() throws Exception {
		ListNode l1 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		l12.next = new ListNode(3);
		l1.next = l12;

		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		l22.next = new ListNode(4);
		l2.next = l22;

		ListNode r = new ListNode(7);
		ListNode r2 = new ListNode(0);
		r2.next = new ListNode(8);
		r.next = r2;

		ReflectionAssert.assertReflectionEquals(r, solution.addTwoNumbers(l1, l2));
	}

}