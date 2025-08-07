package twoPointer

import scala.annotation.tailrec

object InPLaceReverseString extends App {
  /**
   * Write a function that reverses a string. The input string is given as an array of characters s.
   *
   * You must do this by modifying the input array in-place with O(1) extra memory.
   *
   *
   *
   * Example 1:
   *
   * Input: s = ["h","e","l","l","o"]
   * Output: ["o","l","l","e","h"]
   * Example 2:
   *
   * Input: s = ["H","a","n","n","a","h"]
   * Output: ["h","a","n","n","a","H"]
   */

  def reverseString(s: Array[Char]): Unit = {
    @tailrec
    def helper(start: Int, end: Int): Array[Char] = {
      if (start >= end) s
      else {
        val startV = s(start)
        s(start) = s(end)
        s(end) = startV
        helper(start + 1, end - 1)
      }
    }

    helper(0, s.size - 1)
  }
}
