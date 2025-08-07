package twoPointer

import util.ArrayUtil.switchPlaces

import scala.annotation.tailrec


object ReverseVowelsOfAString extends App {
  /**
   * Given a string s, reverse only all the vowels in the string and return it.
   *
   * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
   *
   *
   *
   * Example 1:
   *
   * Input: s = "IceCreAm"
   *
   * Output: "AceCreIm"
   *
   * Explanation:
   *
   * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
   *
   * Example 2:
   *
   * Input: s = "leetcode"
   *
   * Output: "leotcede"
   *
   *
   *
   * Constraints:
   *
   * 1 <= s.length <= 3 * 105
   * s consist of printable ASCII characters.
   */
  implicit class CharHelper(char: Char) {
    private val vowels = Set('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U')

    def isVowel = vowels.contains(char)
  }

  def reverseVowels(s: String): String = {
    val charArray: Array[Char] = s.toCharArray
    @tailrec
    def helper(firstVowel: Int, lastVowel: Int): String = {
      if (firstVowel >= lastVowel) charArray.mkString
      else {
        (s(firstVowel).isVowel, s(lastVowel).isVowel) match {
          case (true, true) =>
            switchPlaces(firstVowel, lastVowel, charArray)
            helper(firstVowel + 1, lastVowel - 1)
          case (true, false) =>
            helper(firstVowel, lastVowel - 1)
          case (false, true) =>
            helper(firstVowel + 1, lastVowel)
          case _ =>
            helper(firstVowel + 1, lastVowel - 1)
        }
      }
    }

    helper(0, s.length - 1)
  }

  println(reverseVowels("IceCreAm"))
}
