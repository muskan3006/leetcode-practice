package twoPointer

import util.ArrayUtil.{reverseWithIndex, switchPlaces}

import scala.annotation.tailrec

object ReverseStringK2K extends App {

  /**
   * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
   *
   * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
   *
   *
   *
   * Example 1:
   *
   * Input: s = "abcdefg", k = 2
   * Output: "bacdfeg"
   * Example 2:
   *
   * Input: s = "abcd", k = 2
   * Output: "bacd"
   *
   *
   * Constraints:
   *
   * 1 <= s.length <= 104
   * s consists of only lowercase English letters.
   * 1 <= k <= 104
   */

  def reverseStr(s: String, k: Int): String = {
    val array: Array[Char] = s.toCharArray
    val size = array.size

    @tailrec
    def helper(kPtr: Int, k2Ptr: Int): String = {
      if (k2Ptr >= size) {
        if (kPtr >= size) {
          reverseWithIndex(k2Ptr - k - k + 1, size - 1, array).mkString
        } else {
          reverseWithIndex(kPtr - (k - 1), kPtr, array).mkString
        }
      } else {
        reverseWithIndex(kPtr - (k - 1), kPtr, array)
        helper(k2Ptr + k, k2Ptr + (2 * k))
      }
    }

    helper(k - 1, (2 * k) - 1)
  }

  println(reverseStr("abcd", 2))
}
