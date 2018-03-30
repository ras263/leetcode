import org.junit.Before;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.io.FileReader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

import static org.junit.Assert.*;

/**
 * Test class for medium problem solutions.
 *
 * Created by Lakhno Anton on 29.03.2018.
 */
public class SolutionTest {

	Solution solution;
	String longString;

	@Before
	public void setUp() throws Exception {
		solution = new Solution();

		try (FileReader fr = new FileReader("src/main/resources/problem3.txt")) {
			char[] cbuf = new char[31652];
			fr.read(cbuf);
			longString = new String(cbuf);
		}
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

	@Test
	public void addTwoNumbersWithZeros() throws Exception {
		ReflectionAssert.assertReflectionEquals(new ListNode(0), solution.addTwoNumbers(new ListNode(0), new ListNode(0)));
	}

	@Test
	public void lengthOfLongestSubstring() throws Exception {
		assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
		assertEquals(1, solution.lengthOfLongestSubstring("bbbbbb"));
		assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
	}

	@Test
	public void lengthOfLongestSubstringWithSingleCharInput() throws Exception {
		assertEquals(1, solution.lengthOfLongestSubstring("c"));
	}

	@Test
	public void lengthOfLongestSubstringWithAu() throws Exception {
		assertEquals(2, solution.lengthOfLongestSubstring("au"));
	}

	@Test
	public void lengthOfLongestSubstringV2() throws Exception {
		assertEquals(3, solution.lengthOfLongestSubstringV2("abcabcbb"));
		assertEquals(1, solution.lengthOfLongestSubstringV2("bbbbbb"));
		assertEquals(3, solution.lengthOfLongestSubstringV2("pwwkew"));
	}

	@Test
	public void lengthOfLongestSubstringWithSingleCharInputV2() throws Exception {
		assertEquals(1, solution.lengthOfLongestSubstringV2("c"));
	}

	@Test
	public void lengthOfLongestSubstringWithAuV2() throws Exception {
		assertEquals(2, solution.lengthOfLongestSubstringV2("au"));
	}

	@Test
	public void lengthOfLongestSubstringPerformanceTest() throws Exception {
		System.out.println("Testing with string: \n " + longString);

		long start = System.nanoTime();
		solution.lengthOfLongestSubstring(longString);
		long first = (System.nanoTime() - start) / 1_000;
		System.out.println(String.format("First solution tooks %d mcs", first));

		start = System.nanoTime();
		solution.lengthOfLongestSubstringV2(longString);
		long second = (System.nanoTime() - start) / 1_000;
		System.out.println(String.format("Second solution tooks %d mcs", second));

		System.out.println("Performance speedup rate is: " + first / second);
	}

}