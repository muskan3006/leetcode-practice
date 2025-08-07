package twoPointer

import util.ArrayUtil.reverseWithIndex

import scala.annotation.tailrec

object ReverseWords extends App {

  /**
   * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
   *
   *
   *
   * Example 1:
   *
   * Input: s = "Let's take LeetCode contest"
   * Output: "s'teL ekat edoCteeL tsetnoc"
   * Example 2:
   *
   * Input: s = "Mr Ding"
   * Output: "rM gniD"
   *
   *
   * Constraints:
   *
   * 1 <= s.length <= 5 * 104
   * s contains printable ASCII characters.
   * s does not contain any leading or trailing spaces.
   * There is at least one word in s.
   * All the words in s are separated by a single space.
   *
   * @param s
   * @return
   */

  def reverseWords(s: String): String = {
    val array = s.toCharArray
    val size = array.size

    @tailrec
    def helper(start: Int, end: Int): Array[Char] = {
      println(array.toList)
      if (end >= size)
        array
      else if (end == size - 1) {
        reverseWithIndex(start, end, array)
        helper(start, end + 1)
      } else {
        if (array(end) == ' ') {
          reverseWithIndex(start, end - 1, array)
          helper(end + 1, end + 2)
        } else {
          helper(start, end + 1)
        }
      }
    }

    if (size <= 1) s
    else helper(0, 1).mkString
  }

  println(reverseWords("Let's take LeetCode contest"))
}
