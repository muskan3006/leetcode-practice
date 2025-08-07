package slidingWindow

import scala.annotation.tailrec

object LongestSubstringWithoutRepeatingCharacters extends App {

  /**
   * Given a string s, find the length of the longest substring without duplicate characters.
   *
   *
   *
   * Example 1:
   *
   * Input: s = "abcabcbb"
   * Output: 3
   * Explanation: The answer is "abc", with the length of 3.
   * Example 2:
   *
   * Input: s = "bbbbb"
   * Output: 1
   * Explanation: The answer is "b", with the length of 1.
   * Example 3:
   *
   * Input: s = "pwwkew"
   * Output: 3
   * Explanation: The answer is "wke", with the length of 3.
   * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
   *
   *
   * Constraints:
   *
   * 0 <= s.length <= 5 * 104
   * s consists of English letters, digits, symbols and spaces.
   */

  def lengthOfLongestSubstring(s: String): Int = {
    val size = s.length

    @tailrec
    def helper(left: Int, right: Int, mapCharIndex: Map[Char, Int], max: Int): Int = {
      if (right < size) {
        val char = s(right)
        mapCharIndex.get(char) match {
          case Some(value) => helper(value + 1, value + 1, Map.empty, max)
          case None => helper(left, right + 1, mapCharIndex + (char -> right), Math.max(max, right - left + 1))
        }
      } else max
    }

    helper(0, 0, Map.empty, 0)
  }

  println(lengthOfLongestSubstring("geeksforgeeks"))
}
