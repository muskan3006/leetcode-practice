package twoPointer

import scala.annotation.tailrec

object StringOccurInOtherString extends App {
  /**
   * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
   *
   *
   *
   * Example 1:
   *
   * Input: haystack = "sadbutsad", needle = "sad"
   * Output: 0
   * Explanation: "sad" occurs at index 0 and 6.
   * The first occurrence is at index 0, so we return 0.
   * Example 2:
   *
   * Input: haystack = "leetcode", needle = "leeto"
   * Output: -1
   * Explanation: "leeto" did not occur in "leetcode", so we return -1.
   */

  def strStr(haystack: String, needle: String): Int = {
    val needleSize = needle.length
    val haystackSize = haystack.length

    @tailrec
    def findStartIndex(ptr1: Int, ptr2: Int, startIndex: Int): Int = {
      if (ptr1 >= needleSize || ptr2 >= haystackSize) {
        if (ptr1 != 0 && ptr1 < needleSize)
          -1
        else startIndex
      } else {
        needle(ptr1) == haystack(ptr2) match {
          case true => findStartIndex(ptr1 + 1, ptr2 + 1, if (startIndex == -1) ptr2 else startIndex)
          case false => findStartIndex(0, if (startIndex == -1) ptr2 + 1 else startIndex + 1, -1)
        }
      }
    }

    if(needleSize > haystackSize) -1 else
      findStartIndex(0, 0, -1)
  }

  println(strStr("mississippi", "issipi"))
}
